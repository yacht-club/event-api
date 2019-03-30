package com.sychev.events.service.impl;

import com.sychev.events.converter.ModelConverter;
import com.sychev.events.exception.NotFoundTaskException;
import com.sychev.events.model.request.AddTaskRequest;
import com.sychev.events.model.response.TaskInfo;
import com.sychev.events.repository.TaskRepository;
import com.sychev.events.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TaskInfo> getAllTasks() {
        return repository.findAll().stream()
                .map(ModelConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public TaskInfo getTask(UUID taskUid) {
        return ModelConverter.convert(repository.findByTaskUid(taskUid).orElseThrow(() -> {
            logger.info("Not found task with uid: " + taskUid);
            return new NotFoundTaskException("Not found task with uid: " + taskUid);
        }));
    }

    @Override
    public UUID addTask(AddTaskRequest request) {
        return repository.save(ModelConverter.convert(request)).getTaskUid();
    }
}
