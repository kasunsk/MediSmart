package com.company.medismart.channel.model;

import javax.persistence.*;

@Entity
@Table(name = "PATIENT_MEDICINE")
public class PatientMedicineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATIENT_MEDICINE_ID", nullable = false)
    private Long patientMedicineId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "PATIENT_HISTORY_ID", nullable = false)
    private PatientHistoryModel patientHistory;

    @Column(name = "MEDICINE_VALIDITY", nullable = false)
    private String timePeriod;

    @Column(name = "MEDICINE_AND_QUANTITY", nullable = false)
    private String medicineQuantityMap;

    public Long getPatientMedicineId() {
        return patientMedicineId;
    }

    public void setPatientMedicineId(Long patientMedicineId) {
        this.patientMedicineId = patientMedicineId;
    }

    public PatientHistoryModel getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(PatientHistoryModel patientHistory) {
        this.patientHistory = patientHistory;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    public String getMedicineQuantityMap() {
        return medicineQuantityMap;
    }

    public void setMedicineQuantityMap(String medicineQuantityMap) {
        this.medicineQuantityMap = medicineQuantityMap;
    }
}
