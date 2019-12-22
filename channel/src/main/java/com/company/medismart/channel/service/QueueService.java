package com.company.medismart.channel.service;

import com.company.medismart.channel.dto.Queue;
import com.company.medismart.channel.dto.QueuePatient;

import java.util.List;

public interface QueueService {
    Queue createQue(String doctorUserId);
    void inActiveQueue(Long queId);
    Integer addPatientToQueue(Long queId, String patientId);
    List<QueuePatient> loadAllQuePatients(Long queId);
}
