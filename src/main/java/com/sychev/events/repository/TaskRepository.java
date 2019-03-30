package com.sychev.events.repository;

import com.sychev.events.model.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Integer, TaskEntity> {
}
