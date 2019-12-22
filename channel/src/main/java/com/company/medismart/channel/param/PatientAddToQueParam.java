package com.company.medismart.channel.param;

public class PatientAddToQueParam {

    private Long queId;
    private String patientId;

    public Long getQueId() {
        return queId;
    }

    public void setQueId(Long queId) {
        this.queId = queId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
