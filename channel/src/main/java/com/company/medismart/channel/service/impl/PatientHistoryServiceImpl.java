package com.company.medismart.channel.service.impl;

import com.company.medismart.channel.dto.PatientHistory;
import com.company.medismart.channel.service.PatientHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("patientHistoryService")
public class PatientHistoryServiceImpl implements PatientHistoryService {
    @Override
    public void addPatientHistoryRecord(PatientHistory patientHistory) {

    }

    @Override
    public List<PatientHistory> loadPatientHistories(String patientNic) {
        return null;
    }
}
