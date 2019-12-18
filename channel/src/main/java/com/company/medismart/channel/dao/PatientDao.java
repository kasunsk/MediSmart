package com.company.medismart.channel.dao;

import com.company.medismart.channel.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("patientDao")
public interface PatientDao extends JpaRepository<PatientModel, String> {
    PatientModel findByNic(String nic);
}
