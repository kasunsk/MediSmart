package com.company.medismart.channel.service.impl;

import com.company.medismart.channel.adaptor.PatientHistoryModelAdaptor;
import com.company.medismart.channel.dao.PatientHistoryDao;
import com.company.medismart.channel.dto.MedicineIssueStatus;
import com.company.medismart.channel.dto.PatientHistory;
import com.company.medismart.channel.model.PatientHistoryModel;
import com.company.medismart.channel.model.PatientMedicineModel;
import com.company.medismart.channel.param.PatientHistoryLoadRequest;
import com.company.medismart.channel.service.PatientHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service("patientHistoryService")
public class PatientHistoryServiceImpl implements PatientHistoryService {

    @Autowired
    private PatientHistoryDao patientHistoryDao;

    @Autowired
    private PatientHistoryModelAdaptor patientHistoryModelAdaptor;

    @Transactional
    @Override
    public void addPatientHistoryRecord(PatientHistory patientHistory) {
        PatientHistoryModel patientHistoryModel = patientHistoryModelAdaptor.fromDto(patientHistory);
        if (patientHistoryModel.getProvidedMedicine() != null) {
            patientHistoryModel.getProvidedMedicine().setPatientHistory(patientHistoryModel);
        }
        patientHistoryDao.save(patientHistoryModel);
    }

    @Transactional
    @Override
    public void issueMedicineForPatient(Long patientHistoryId) {

        PatientHistoryModel historyModel = patientHistoryDao.findOneByPatientHistoryId(patientHistoryId);
        if (historyModel != null) {
            PatientMedicineModel patientMedicineModel = historyModel.getProvidedMedicine();
            patientMedicineModel.setStatus(MedicineIssueStatus.ISSUED);
            historyModel.setProvidedMedicine(patientMedicineModel);
            patientHistoryDao.save(historyModel);
        }
    }

    @Transactional
    @Override
    public Page<PatientHistory> loadPatientHistories(PatientHistoryLoadRequest loadRequest) {
        loadRequest.setSort(Sort.by("patientHistoryId"));
        Page<PatientHistoryModel> historyModels = patientHistoryDao.findAllByPatientNic(loadRequest.getPatientNic(), loadRequest);
        return patientHistoryModelAdaptor.fromModelPage(historyModels);
    }

    @Transactional
    @Override
    public PatientHistory loadQuePatientHistory(Long queueId, String nic) {
        PatientHistoryModel historyModel = patientHistoryDao.findOneByPatientNicAndProvidedMedicineQueueIdAndProvidedMedicineStatus(
                nic, queueId, MedicineIssueStatus.TO_BE_ISSUE);
        return patientHistoryModelAdaptor.fromModel(historyModel);
    }
}
