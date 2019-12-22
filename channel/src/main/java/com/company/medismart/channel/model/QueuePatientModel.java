package com.company.medismart.channel.model;

import com.company.medismart.channel.dto.QueuePatientStatus;

import javax.persistence.*;

@Entity
@Table(name = "QUEUE_PATIENT")
public class QueuePatientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUEUE_PATIENT_ID", nullable = false)
    private Long quePatientId;

    @Column(name = "PATIENT_NIC", nullable = false)
    private String patientNic;

    @Column(name = "QUEUE_ID", nullable = false)
    private Integer queNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "QUEUE_ID", nullable = false, insertable = false, updatable = false)
    private QueModel queueId;

    @Enumerated(EnumType.STRING)
    @Column(name = "QUEUE_PATIENT_STATUS", nullable = false)
    private QueuePatientStatus status;

    public Long getQuePatientId() {
        return quePatientId;
    }

    public void setQuePatientId(Long quePatientId) {
        this.quePatientId = quePatientId;
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

    public QueModel getQueueId() {
        return queueId;
    }

    public void setQueueId(QueModel queueId) {
        this.queueId = queueId;
    }

    public QueuePatientStatus getStatus() {
        return status;
    }

    public void setStatus(QueuePatientStatus status) {
        this.status = status;
    }
}