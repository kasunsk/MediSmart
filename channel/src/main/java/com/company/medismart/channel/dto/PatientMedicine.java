package com.company.medismart.channel.dto;

import java.util.Map;

public class PatientMedicine {
    private Long patientMedicineId;
    private Long patientHistoryId;
    private String timePeriod;
    private Map<String,String> medicineQuantityMap;

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

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    public Map<String, String> getMedicineQuantityMap() {
        return medicineQuantityMap;
    }

    public void setMedicineQuantityMap(Map<String, String> medicineQuantityMap) {
        this.medicineQuantityMap = medicineQuantityMap;
    }
}
