package com.company.medismart.channel.service;

import com.company.medismart.channel.dto.Patient;
import com.company.medismart.channel.dto.PatientMedicine;
import com.company.medismart.channel.dto.Queue;
import com.company.medismart.channel.param.MedicineIssueRequest;
import com.company.medismart.channel.param.PageableSupport;
import org.springframework.data.domain.Page;

public interface ChannellingService {
    Patient callNextPatient(Long queueId);
    void completeChannelling(MedicineIssueRequest medicineIssueRequest);
    PatientMedicine viewQueuePatientMedicine(Long queId, String patientNic);
    Boolean issueMedicine(Long queId, String patientNic);
}
