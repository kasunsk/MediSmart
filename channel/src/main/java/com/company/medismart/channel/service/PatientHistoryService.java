package com.company.medismart.channel.service;

import com.company.medismart.channel.dto.PatientHistory;

import java.util.List;

public interface PatientHistoryService {

    void addPatientHistoryRecord(PatientHistory patientHistory);
    List<PatientHistory> loadPatientHistories(String patientNic);
}
