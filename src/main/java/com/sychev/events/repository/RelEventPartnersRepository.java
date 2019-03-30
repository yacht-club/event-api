package com.sychev.events.repository;

import com.sychev.events.model.entity.EventEntity;
import com.sychev.events.model.entity.RelEventPartnersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelEventPartnersRepository extends JpaRepository<RelEventPartnersEntity, Integer> {

    List<RelEventPartnersEntity> findAllByEvent(EventEntity entity);

}
