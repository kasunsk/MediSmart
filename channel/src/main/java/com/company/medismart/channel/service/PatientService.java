package com.company.medismart.channel.service;

import com.company.medismart.channel.dto.Patient;
import com.company.medismart.channel.param.PageableSupport;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PatientService {
    void addPatient(Patient patient);
    boolean removePatient(String nic);
    Patient updatePatient(Patient patient, String currentNic);
    Patient loadPatientByNic(String nic);
    Patient loadPatientByMobileNumber(String mobileNumber);
    List<Patient> loadAll();
    Page<Patient> loadAll(PageableSupport pageable);
}
