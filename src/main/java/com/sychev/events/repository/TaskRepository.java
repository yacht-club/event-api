package com.sychev.events.repository;

import com.sychev.events.model.entity.EventEntity;
import com.sychev.events.model.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    Optional<TaskEntity> findByTaskUid(UUID uid);

    List<TaskEntity> findAllByPrsExtId(String prsExtId);

    List<TaskEntity> findAllByEvent(EventEntity event);
}
