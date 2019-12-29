package com.company.medismart.channel.model;

import com.company.medismart.channel.dto.QueuePatientStatus;
import com.company.medismart.core.model.AbstractTrackableEntity;

import javax.persistence.*;

@Entity
@Table(name = "QUEUE_PATIENT")
public class QueuePatientModel extends AbstractTrackableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUEUE_PATIENT_ID", nullable = false)
    private Long quePatientId;

    @Column(name = "PATIENT_NIC", nullable = false)
    private String patientNic;

    @Column(name = "QUEUE_NUMBER", nullable = false)
    private Integer queNumber;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "QUEUE_ID")
    private QueueModel queue;

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

    public QueueModel getQueue() {
        return queue;
    }

    public void setQueue(QueueModel queue) {
        this.queue = queue;
    }

    public QueuePatientStatus getStatus() {
        return status;
    }

    public void setStatus(QueuePatientStatus status) {
        this.status = status;
    }
}
