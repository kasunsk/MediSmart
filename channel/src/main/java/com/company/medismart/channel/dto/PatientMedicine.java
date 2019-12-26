package com.company.medismart.channel.dto;

import java.util.ArrayList;
import java.util.List;

public class PatientMedicine {
    private Long patientMedicineId;
    private Long patientHistoryId;
    private List<PatientMedicineRecord> patientMedicineRecord = new ArrayList<>();

    public Long getPatientMedicineId() {
        return patientMedicineId;
    }

    public void setPatientMedicineId(Long patientMedicineId) {
        this.patientMedicineId = patientMedicineId;
    }

    public Long getPatientHistoryId() {
        return patientHistoryId;
    }

    public void setPatientHistoryId(Long patientHistoryId) {
        this.patientHistoryId = patientHistoryId;
    }

    public List<PatientMedicineRecord> getPatientMedicineRecord() {
        return patientMedicineRecord;
    }

    public void setPatientMedicineRecord(List<PatientMedicineRecord> patientMedicineRecord) {
        this.patientMedicineRecord = patientMedicineRecord;
    }
}
