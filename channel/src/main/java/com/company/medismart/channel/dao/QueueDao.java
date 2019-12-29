package com.company.medismart.channel.dao;

import com.company.medismart.channel.model.QueueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("queueDao")
public interface QueueDao extends JpaRepository<QueueModel, Long> {


}
