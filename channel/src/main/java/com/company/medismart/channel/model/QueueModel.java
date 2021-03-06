package com.company.medismart.channel.model;

import com.company.medismart.channel.dto.QueueStatus;
import com.company.medismart.core.model.AbstractTrackableEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_QUEUE")
public class QueueModel extends AbstractTrackableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUEUE_ID", nullable = false)
    private Long queueId;

    @Column(name = "DOCTOR_ID", nullable = false)
    private String doctorUserId;

    @Enumerated(EnumType.STRING)
    @Column(name = "QUE_STATUS", nullable = false)
    private QueueStatus status;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "queue")
    private List<QueuePatientModel> patients = new ArrayList<>();

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

    public QueueStatus getStatus() {
        return status;
    }

    public void setStatus(QueueStatus status) {
        this.status = status;
    }

    public List<QueuePatientModel> getPatients() {
        return patients;
    }

    public void setPatients(List<QueuePatientModel> patients) {
        this.patients = patients;
    }
}
