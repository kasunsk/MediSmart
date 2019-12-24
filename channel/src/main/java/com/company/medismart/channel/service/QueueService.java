package com.company.medismart.channel.service;

import com.company.medismart.channel.dto.Queue;
import com.company.medismart.channel.dto.QueuePatient;
import com.company.medismart.channel.param.PageableSupport;
import com.company.medismart.channel.param.QueuePatientLoadRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface QueueService {
    Queue createQue(String doctorUserId);
    void inActiveQueue(Long queId);
    Integer addPatientToQueue(Long queId, String patientId);
    List<QueuePatient> loadAllQuePatients(Long queId);
    Queue loadQueById(Long queId);
    Page<Queue> loadAllQue(PageableSupport pageableSupport);
    Page<QueuePatient> loadAllQueuePatients(QueuePatientLoadRequest loadRequest);
}
