package com.company.medismart.channel.service.impl;

import com.company.medismart.channel.dao.QuePatientDao;
import com.company.medismart.channel.dao.QueueDao;
import com.company.medismart.channel.dto.*;
import com.company.medismart.channel.model.QueModel;
import com.company.medismart.channel.model.QueuePatientModel;
import com.company.medismart.channel.param.MedicineIssueRequest;
import com.company.medismart.channel.service.ChannellingService;
import com.company.medismart.channel.service.PatientHistoryService;
import com.company.medismart.channel.service.PatientService;
import com.company.medismart.channel.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service("channellingService")
public class ChannellingServiceImpl implements ChannellingService {

    @Autowired
    private QueueDao queueDao;

    @Autowired
    private QuePatientDao quePatientDao;

    @Autowired
    private QueueService queueService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientHistoryService patientHistoryService;

    @Transactional
    @Override
    public Patient callNextPatient(Long queueId) {
        QueModel queModel = queueDao.getOne(queueId);
        List<QueuePatientModel> queuePatientModels = quePatientDao.findAllByQueue(queModel);
        QueuePatientModel patientModel = queuePatientModels.stream().filter(patient -> QueuePatientStatus.WAITING.equals(patient.getStatus()))
                .min(Comparator.comparing(QueuePatientModel::getQueNumber)).orElseThrow(RuntimeException::new);
        return patientService.loadPatientByNic(patientModel.getPatientNic());
    }

    @Transactional
    @Override
    public void completeChannelling(MedicineIssueRequest medicineIssueRequest) {
        PatientHistory record = medicineIssueRequest.getRecord();
        String patientNic = record.getPatientNic();
        QueModel queModel = queueDao.getOne(medicineIssueRequest.getQueueId());
        QueuePatientModel queuePatientModel = quePatientDao.findOneByQueueAndPatientNic(queModel, patientNic);
        queuePatientModel.setStatus(QueuePatientStatus.CHANNELED);
        quePatientDao.save(queuePatientModel);
        PatientMedicine patientMedicine = record.getProvidedMedicine();
        patientMedicine.setStatus(MedicineIssueStatus.TO_BE_ISSUE);
        patientMedicine.setQueueId(medicineIssueRequest.getQueueId());
        record.setProvidedMedicine(patientMedicine);
        patientHistoryService.addPatientHistoryRecord(record);
    }

    @Transactional
    @Override
    public PatientMedicine viewQueuePatientMedicine(Long queId, String patientNic) {
        PatientHistory history = patientHistoryService.loadQuePatientHistory(queId, patientNic);
        return history.getProvidedMedicine();
    }

    @Transactional
    @Override
    public Boolean issueMedicine(Long queId, String patientNic) {
        PatientHistory history = patientHistoryService.loadQuePatientHistory(queId, patientNic);
        patientHistoryService.issueMedicineForPatient(history.getPatientHistoryId());
        QueModel queue = queueDao.getOne(queId);
        QueuePatientModel queuePatientModel = quePatientDao.findOneByQueueAndPatientNic(queue, patientNic);
        queuePatientModel.setStatus(QueuePatientStatus.MEDICATED);
        quePatientDao.save(queuePatientModel);
        return Boolean.TRUE;
    }
}
