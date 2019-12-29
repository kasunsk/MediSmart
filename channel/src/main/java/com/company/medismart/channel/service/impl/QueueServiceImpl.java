package com.company.medismart.channel.service.impl;

import com.company.medismart.channel.adaptor.QueueAdaptor;
import com.company.medismart.channel.adaptor.QueuePatientAdaptor;
import com.company.medismart.channel.dao.PatientHistoryDao;
import com.company.medismart.channel.dao.QuePatientDao;
import com.company.medismart.channel.dao.QueueDao;
import com.company.medismart.channel.dto.*;
import com.company.medismart.channel.model.QueueModel;
import com.company.medismart.channel.model.QueuePatientModel;
import com.company.medismart.channel.param.MedicineIssueRequest;
import com.company.medismart.channel.param.PageableSupport;
import com.company.medismart.channel.param.QueuePatientLoadRequest;
import com.company.medismart.channel.service.PatientService;
import com.company.medismart.channel.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service("queueService")
public class QueueServiceImpl implements QueueService {

    @Autowired
    private PatientService patientService;

    @Autowired
    private QueueDao queueDao;

    @Autowired
    private QuePatientDao quePatientDao;

    @Autowired
    private PatientHistoryDao patientHistoryDao;

    @Autowired
    private QueueAdaptor queueAdaptor;

    @Autowired
    private QueuePatientAdaptor queuePatientAdaptor;

    @Transactional
    @Override
    public Queue createQue(String doctorUserId) {
        QueueModel queueModel = new QueueModel();
        queueModel.setDoctorUserId(doctorUserId);
        queueModel.setStatus(QueueStatus.ACTIVE);
        queueDao.save(queueModel);
        return queueAdaptor.fromModel(queueModel);
    }

    @Transactional
    @Override
    public void inActiveQueue(Long queId) {
        QueueModel queueModel = queueDao.getOne(queId);
        queueModel.setStatus(QueueStatus.IN_ACTIVE);
        queueDao.save(queueModel);
    }

    @Transactional
    @Override
    public Integer addPatientToQueue(Long queId, String patientId) {
        QueueModel queueModel = queueDao.getOne(queId);
        List<QueuePatientModel> queuePatientModels = queueModel.getPatients();
        QueuePatientModel lastPatient = queuePatientModels.stream().max(Comparator.comparing(QueuePatientModel::getQueNumber)).orElse(new QueuePatientModel());
        Integer nextQueueNumber = lastPatient.getQueNumber() == null ? 1 : lastPatient.getQueNumber() + 1;
        QueuePatientModel newPatient = new QueuePatientModel();
        newPatient.setPatientNic(patientId);
        newPatient.setStatus(QueuePatientStatus.WAITING);
        newPatient.setQueNumber(nextQueueNumber);
        newPatient.setQueue(queueModel);
        quePatientDao.save(newPatient);
        return nextQueueNumber;
    }

    @Transactional
    @Override
    public List<QueuePatient> loadAllQuePatients(Long queId) {

        QueueModel queueModel = queueDao.getOne(queId);
        Queue queue = queueAdaptor.fromModel(queueModel);
        return queue.getPatients();
    }

    @Transactional
    @Override
    public Queue loadQueById(Long queId) {
        QueueModel queueModel = queueDao.getOne(queId);
        queueModel.setPatients(new ArrayList<>());
        return queueAdaptor.fromModel(queueModel);
    }

    @Transactional
    @Override
    public Page<Queue> loadAllQue(PageableSupport pageableSupport) {
        Page<QueueModel> pagedQueues = queueDao.findAll(pageableSupport);
        return queueAdaptor.fromModelPage(pagedQueues);
    }

    @Transactional
    @Override
    public Page<QueuePatient> loadAllQueuePatients(QueuePatientLoadRequest loadRequest) {
        QueueModel queueModel = queueDao.getOne(loadRequest.getQueueId());
        loadRequest.setSort(Sort.by("queNumber"));
        Page<QueuePatientModel> patientModelPage = quePatientDao.findAllByQueue(queueModel,loadRequest);
        return queuePatientAdaptor.fromModelPage(patientModelPage);
    }

    @Transactional
    @Override
    public Patient callNextPatient(Long queueId) {
        QueueModel queueModel = queueDao.getOne(queueId);
        List<QueuePatientModel> queuePatientModels = quePatientDao.findAllByQueue(queueModel);
        QueuePatientModel patientModel = queuePatientModels.stream().filter(patient -> QueuePatientStatus.WAITING.equals(patient.getStatus()))
                .min(Comparator.comparing(QueuePatientModel::getQueNumber)).orElseThrow(RuntimeException::new);
        return patientService.loadPatientByNic(patientModel.getPatientNic());
    }

    @Transactional
    @Override
    public void issueMedicine(MedicineIssueRequest medicineIssueRequest) {
        PatientHistory record = medicineIssueRequest.getRecord();;

    }
}
