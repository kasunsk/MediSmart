package com.company.medismart.channel.service.impl;

import com.company.medismart.channel.adaptor.QueueAdaptor;
import com.company.medismart.channel.dao.QueueDao;
import com.company.medismart.channel.dto.Queue;
import com.company.medismart.channel.dto.QueuePatient;
import com.company.medismart.channel.dto.QueuePatientStatus;
import com.company.medismart.channel.dto.QueueStatus;
import com.company.medismart.channel.model.QueModel;
import com.company.medismart.channel.model.QueuePatientModel;
import com.company.medismart.channel.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service("queueService")
public class QueueServiceImpl implements QueueService {

    @Autowired
    private QueueDao queueDao;

    @Autowired
    private QueueAdaptor queueAdaptor;

    @Transactional
    @Override
    public Queue createQue(String doctorUserId) {
        QueModel queModel = new QueModel();
        queModel.setDoctorUserId(doctorUserId);
        queModel.setStatus(QueueStatus.ACTIVE);
        queueDao.save(queModel);
        return queueAdaptor.fromModel(queModel);
    }

    @Transactional
    @Override
    public void inActiveQueue(Long queId) {
        QueModel queModel = queueDao.getOne(queId);
        queModel.setStatus(QueueStatus.IN_ACTIVE);
        queueDao.save(queModel);
    }

    @Transactional
    @Override
    public Integer addPatientToQueue(Long queId, String patientId) {
        QueModel queModel = queueDao.getOne(queId);
        List<QueuePatientModel> queuePatientModels = queModel.getPatients();
        QueuePatientModel lastPatient = queuePatientModels.stream().max(Comparator.comparing(QueuePatientModel::getQueNumber)).orElse(new QueuePatientModel());
        Integer nextQueueNumber = lastPatient.getQueNumber() + 1;
        QueuePatientModel newPatient = new QueuePatientModel();
        newPatient.setPatientNic(patientId);
        newPatient.setStatus(QueuePatientStatus.WAITING);
        newPatient.setQueNumber(nextQueueNumber);
        queModel.getPatients().add(newPatient);
        queueDao.save(queModel);
        return nextQueueNumber;
    }

    @Override
    public List<QueuePatient> loadAllQuePatients(Long queId) {
        return null;
    }
}
