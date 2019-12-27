package com.company.medismart.channel.service;

import com.company.medismart.channel.dto.Patient;
import com.company.medismart.channel.param.MedicineIssueRequest;

public interface ChannellingService {
    Patient callNextPatient(Long queueId);
    void issueMedicine(MedicineIssueRequest medicineIssueRequest);
}
