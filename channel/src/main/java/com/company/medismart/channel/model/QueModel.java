package com.company.medismart.channel.model;

import com.company.medismart.channel.dto.QueuePatient;
import com.company.medismart.channel.dto.QueueStatus;
import com.company.medismart.core.model.AbstractTrackableEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PATIENT")
public class QueModel extends AbstractTrackableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUEUE_ID", nullable = false)
    private Long queueId;

    @Column(name = "DOCTOR_ID", nullable = false)
    private String doctorUserId;

    @Column(name = "CURRENT_DATE", nullable = false)
    private Date currentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "QUE_STATUS", nullable = false)
    private QueueStatus status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quePatientId")
    private List<QueuePatient> patients;

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

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public List<QueuePatient> getPatients() {
        return patients;
    }

    public void setPatients(List<QueuePatient> patients) {
        this.patients = patients;
    }

    public QueueStatus getStatus() {
        return status;
    }

    public void setStatus(QueueStatus status) {
        this.status = status;
    }
}
