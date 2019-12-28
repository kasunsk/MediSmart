package com.company.medismart.channel.service.impl;

import com.company.medismart.channel.adaptor.PatientAdaptor;
import com.company.medismart.channel.dao.PatientDao;
import com.company.medismart.channel.dto.Patient;
import com.company.medismart.channel.model.PatientModel;
import com.company.medismart.channel.param.PageableSupport;
import com.company.medismart.channel.service.PatientService;
import com.company.medismart.core.exception.ServiceRuntimeException;
import com.company.medismart.core.exception.dto.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
        PatientModel currentPatient = patientDao.findByNic(patient.getNic());
        if (currentPatient != null) {
            throw new ServiceRuntimeException("Patient Already Exist", ErrorCode.ALREADY_EXIST);
        }
        PatientModel patientModel = patientAdaptor.fromDto(patient);
        patientDao.save(patientModel);
    }

    @Override
    public boolean removePatient(String nic) {
        PatientModel patientModel = patientDao.getOne(nic);
        patientDao.delete(patientModel);
        return Boolean.TRUE;
    }

    @Override
    public Patient updatePatient(Patient patient, String currentNic) {
        PatientModel patientModel = patientDao.getOne(currentNic);
        PatientModel updatedPatient = patientAdaptor.fromDto(patient);
        updateModel(updatedPatient, patientModel);
        patientDao.save(patientModel);
        return patient;
    }

    @Override
    public Patient loadPatientByNic(String nic) {
        PatientModel patientModel = patientDao.getOne(nic);
        return patientAdaptor.fromModel(patientModel);
    }

    @Transactional
    @Override
    public Patient loadPatientByMobileNumber(String mobileNumber) {
        return null;
    }

    @Transactional
    @Override
    public List<Patient> loadAll() {
        List<PatientModel> patientModels = patientDao.findAll();
        return patientAdaptor.fromModelList(patientModels);
    }

    @Transactional
    @Override
    public Page<Patient> loadAll(PageableSupport pageable) {
        Page<PatientModel> patientPage = patientDao.findAll(pageable);
        return patientAdaptor.fromModelPage(patientPage);
    }

    private void updateModel(PatientModel updatedPatient, PatientModel patientModel) {
        //todo impl
    }
}
