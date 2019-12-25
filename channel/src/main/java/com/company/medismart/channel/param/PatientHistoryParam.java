package com.company.medismart.channel.param;

import com.company.medismart.channel.dto.PatientDiseaseStatus;
import com.company.medismart.channel.dto.PatientMedicine;

public class PatientHistoryParam {

    private Long patientHistoryId;
    private String patientNic;
    private String disease;
    private PatientDiseaseStatus diseaseStatus;
    private PatientMedicine providedMedicine;
    private String createdDate;

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

    public PatientMedicine getProvidedMedicine() {
        return providedMedicine;
    }

    public void setProvidedMedicine(PatientMedicine providedMedicine) {
        this.providedMedicine = providedMedicine;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
