package com.company.medismart.channel.param;

import com.company.medismart.channel.dto.QueuePatient;
import com.company.medismart.channel.dto.QueueStatus;

import java.util.Date;
import java.util.List;

public class QueueResponseParam {

    private Long queueId;
    private String doctorUserId;
    private List<QueuePatientResponseParam> patients;
    private QueueStatus status;
    protected String createdDate;
    protected String lastModifiedDate;

    public Long getQueueId() {
        return queueId;
    }

    public void setQueueId(Long queueId) {
        this.queueId = queueId;
    }

    public String getDoctorUserId() {
        return doctorUserId;
    }

    public void setDoctorUserId(String doctorUserId) {
        this.doctorUserId = doctorUserId;
    }

    public List<QueuePatientResponseParam> getPatients() {
        return patients;
    }

    public void setPatients(List<QueuePatientResponseParam> patients) {
        this.patients = patients;
    }

    public QueueStatus getStatus() {
        return status;
    }

    public void setStatus(QueueStatus status) {
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
