package com.company.medismart.channel.model;

import com.company.medismart.channel.dto.MedicineIssueStatus;

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

    @Column(name = "QUEUE_ID", nullable = false)
    private Long queueId;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private MedicineIssueStatus status;

    @Column(name = "MEDICINE_AND_QUANTITY", nullable = false)
    private String patientMedicineRecord;

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

    public Long getQueueId() {
        return queueId;
    }

    public void setQueueId(Long queueId) {
        this.queueId = queueId;
    }

    public MedicineIssueStatus getStatus() {
        return status;
    }

    public void setStatus(MedicineIssueStatus status) {
        this.status = status;
    }

    public String getPatientMedicineRecord() {
        return patientMedicineRecord;
    }

    public void setPatientMedicineRecord(String patientMedicineRecord) {
        this.patientMedicineRecord = patientMedicineRecord;
    }
}
