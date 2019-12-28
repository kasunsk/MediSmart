package com.company.medismart.channel.service;

import com.company.medismart.channel.dto.PatientHistory;
import com.company.medismart.channel.param.PatientHistoryLoadRequest;
import org.springframework.data.domain.Page;

public interface PatientHistoryService {

    void addPatientHistoryRecord(PatientHistory patientHistory);
    void issueMedicineForPatient(Long patientHistoryId);
    Page<PatientHistory> loadPatientHistories(PatientHistoryLoadRequest loadRequest);
    PatientHistory loadQuePatientHistory(Long queueId, String nic);
}
