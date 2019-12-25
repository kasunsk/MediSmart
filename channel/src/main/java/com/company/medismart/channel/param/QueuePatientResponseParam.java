package com.company.medismart.channel.param;

import com.company.medismart.channel.dto.QueuePatientStatus;

public class QueuePatientResponseParam {

    private Long patientQueId;
    private String patientNic;
    private Integer queNumber;
    private Long queueId;
    private QueuePatientStatus status;

    public Long getPatientQueId() {
        return patientQueId;
    }

    public void setPatientQueId(Long patientQueId) {
        this.patientQueId = patientQueId;
    }

    public String getPatientNic() {
        return patientNic;
    }

    public void setPatientNic(String patientNic) {
        this.patientNic = patientNic;
    }

    public Integer getQueNumber() {
        return queNumber;
    }

    public void setQueNumber(Integer queNumber) {
        this.queNumber = queNumber;
    }

    public Long getQueueId() {
        return queueId;
    }

    public void setQueueId(Long queueId) {
        this.queueId = queueId;
    }

    public QueuePatientStatus getStatus() {
        return status;
    }

    public void setStatus(QueuePatientStatus status) {
        this.status = status;
    }

}
