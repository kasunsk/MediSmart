package com.company.medismart.channel.dao;

import com.company.medismart.channel.model.QueModel;
import com.company.medismart.channel.model.QueuePatientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("quePatientDao")
public interface QuePatientDao extends JpaRepository<QueuePatientModel, Long> {
    Page<QueuePatientModel> findAllByQueue(QueModel queueId, Pageable pageable);
    List<QueuePatientModel> findAllByQueue(QueModel queueId);
    QueuePatientModel findOneByQueueAndPatientNic(QueModel queueId, String patientNic);
}
