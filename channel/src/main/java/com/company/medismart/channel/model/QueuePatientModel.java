package com.company.medismart.channel.model;

import com.company.medismart.channel.dto.Queue;
import com.company.medismart.channel.dto.QueuePatientStatus;

public class QueuePatientModel {

    private Long quePatientId;
    private String patientNic;
    private Integer queNumber;
    private Queue queueId;
    private QueuePatientStatus status;

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

    public Queue getQueueId() {
        return queueId;
    }

    public void setQueueId(Queue queueId) {
        this.queueId = queueId;
    }

    public QueuePatientStatus getStatus() {
        return status;
    }

    public void setStatus(QueuePatientStatus status) {
        this.status = status;
    }
}
