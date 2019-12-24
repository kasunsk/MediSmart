package com.company.medismart.channel.dao;

import com.company.medismart.channel.model.QueuePatientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("quePatientDao")
public interface QuePatientDao extends JpaRepository<QueuePatientModel, Long> {
    Page<QueuePatientModel> findAllByQueue(Long queueId,Pageable pageable);
}
