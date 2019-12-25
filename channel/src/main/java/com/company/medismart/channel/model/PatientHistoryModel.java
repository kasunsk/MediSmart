package com.company.medismart.channel.model;

import com.company.medismart.channel.dto.PatientDiseaseStatus;
import com.company.medismart.core.model.AbstractTrackableEntity;

import javax.persistence.*;

@Entity
@Table(name = "PATIENT_HISTORY")
public class PatientHistoryModel extends AbstractTrackableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATIENT_HISTORY_ID", nullable = false)
    private Long patientHistoryId;

    @Column(name = "PATIENT_NIC", nullable = false)
    private String patientNic;

    @Column(name = "DISEASE", nullable = false)
    private String disease;

    @Enumerated(EnumType.STRING)
    @Column(name = "DISEASE_STATUS", nullable = false)
    private PatientDiseaseStatus diseaseStatus;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "queue")
    private PatientMedicineModel providedMedicine;

    public Long getPatientHistoryId() {
        return patientHistoryId;
    }

    public void setPatientHistoryId(Long patientHistoryId) {
        this.patientHistoryId = patientHistoryId;
    }

    public String getPatientNic() {
        return patientNic;
    }

    public void setPatientNic(String patientNic) {
        this.patientNic = patientNic;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public PatientDiseaseStatus getDiseaseStatus() {
        return diseaseStatus;
    }

    public void setDiseaseStatus(PatientDiseaseStatus diseaseStatus) {
        this.diseaseStatus = diseaseStatus;
    }

    public PatientMedicineModel getProvidedMedicine() {
        return providedMedicine;
    }

    public void setProvidedMedicine(PatientMedicineModel providedMedicine) {
        this.providedMedicine = providedMedicine;
    }
}
