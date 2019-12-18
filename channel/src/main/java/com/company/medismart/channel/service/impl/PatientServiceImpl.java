package com.company.medismart.channel.service.impl;

import com.company.medismart.channel.adaptor.PatientAdaptor;
import com.company.medismart.channel.dao.PatientDao;
import com.company.medismart.channel.dto.Patient;
import com.company.medismart.channel.model.PatientModel;
import com.company.medismart.channel.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private PatientAdaptor patientAdaptor;

    @Transactional
    @Override
    public void addPatient(Patient patient) {
        PatientModel patientModel = patientAdaptor.fromDto(patient);
        patientDao.save(patientModel);
    }

    @Override
    public boolean removePatient(String nic) {
        return false;
    }

    @Override
    public Patient updatePatient(Patient patient, String currentNic) {
        return null;
    }

    @Override
    public Patient loadPatientByNic(String nic) {
        return null;
    }

    @Override
    public Patient loadPatientByMobileNumber(String mobileNumber) {
        return null;
    }

    @Override
    public List<Patient> loadAllPatientByDate(String date) {
        return null;
    }
}
