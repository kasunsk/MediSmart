package com.company.medismart.channel.dao;

import com.company.medismart.channel.dto.MedicineIssueStatus;
import com.company.medismart.channel.model.PatientHistoryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("patientHistoryDao")
public interface PatientHistoryDao extends JpaRepository<PatientHistoryModel, Long> {

    List<PatientHistoryModel> findAllByPatientNic(String nic);

    PatientHistoryModel findOneByPatientHistoryId(Long historyId);

    Page<PatientHistoryModel> findAllByPatientNic(String nic, Pageable pageable);

    PatientHistoryModel findOneByPatientNicAndProvidedMedicineQueueIdAndProvidedMedicineStatus(String nic, Long queueId, MedicineIssueStatus medicineStatus);
}
