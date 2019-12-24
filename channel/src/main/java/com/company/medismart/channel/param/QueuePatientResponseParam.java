package com.company.medismart.channel.param;

import com.company.medismart.channel.dto.Queue;
import com.company.medismart.channel.dto.QueuePatientStatus;

public class QueuePatientResponseParam {

    private Long patientQueId;
    private String patientNic;
    private Integer queNumber;
    private Long queueId;
    private QueuePatientStatus status;
    private String createdDate;
    private String lastModifiedDate;

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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
