package com.company.medismart.channel.service.impl;

import com.company.medismart.channel.dto.Queue;
import com.company.medismart.channel.model.QueModel;
import com.company.medismart.channel.service.QueueService;
import org.springframework.stereotype.Service;

@Service("queueService")
public class QueueServiceImpl implements QueueService {

    @Override
    public Queue createQue(String doctorUserId) {
        QueModel queModel = new QueModel();
        return null;
    }

    @Override
    public void inActiveQueue(Long queId) {

    }

    @Override
    public Integer addPatientToQueue(Long queId, String patientId) {
        return null;
    }
}
