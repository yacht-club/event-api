package com.sychev.events.repository;

import com.sychev.events.model.entity.CommunicationHistoryEntity;
import com.sychev.events.model.entity.EventEntity;
import com.sychev.events.model.entity.RelEventPartnersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommunicationHistoryRepository extends JpaRepository<CommunicationHistoryEntity, Integer> {

    List<CommunicationHistoryEntity> findAllByEvent(EventEntity entity);

}
