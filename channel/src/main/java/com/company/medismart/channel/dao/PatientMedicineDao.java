package com.company.medismart.channel.dao;

import com.company.medismart.channel.model.PatientMedicineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("patientMedicineDao")
public interface PatientMedicineDao extends JpaRepository<PatientMedicineModel, Long> {
}
