package com.company.medismart.channel.param;

public class MedicineLoadRequest {
    private Long queueId;
    private String patientNic;

    public Long getQueueId() {
        return queueId;
    }

    public void setQueueId(Long queueId) {
        this.queueId = queueId;
    }

    public String getPatientNic() {
        return patientNic;
    }

    public void setPatientNic(String patientNic) {
        this.patientNic = patientNic;
    }
}
