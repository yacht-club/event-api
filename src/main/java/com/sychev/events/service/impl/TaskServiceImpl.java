package com.sychev.events.service.impl;

import com.sychev.events.converter.ModelConverter;
import com.sychev.events.exception.NotFoundEventException;
import com.sychev.events.exception.NotFoundTaskException;
import com.sychev.events.model.TaskEnum;
import com.sychev.events.model.entity.EventEntity;
import com.sychev.events.model.entity.TaskEntity;
import com.sychev.events.model.request.AddTaskRequest;
import com.sychev.events.model.request.LinkTaskWithPartnerRequest;
import com.sychev.events.model.request.UpdateTaskRequest;
import com.sychev.events.model.response.TaskInfo;
import com.sychev.events.repository.EventRepository;
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

    private final TaskRepository taskRepository;
    private final EventRepository eventRepository;

    @Autowired
    public TaskServiceImpl(
            TaskRepository taskRepository,
            EventRepository eventRepository) {
        this.taskRepository = taskRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<TaskInfo> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(ModelConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskInfo> getAllTasksByPrsExtId(String prsExtId) {
        return taskRepository.findAllByPrsExtId(prsExtId).stream()
                .map(ModelConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskInfo> getAllTasksByEvent(UUID eventUid) {
        EventEntity event = eventRepository.findByEventUid(eventUid).orElseThrow(() -> {
            logger.info("Not found event with uid: " + eventUid);
            return new NotFoundEventException("Not found event with uid: " + eventUid);
        });

        return taskRepository.findAllByEvent(event).stream()
                .map(ModelConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public TaskInfo getTask(UUID taskUid) {
        return ModelConverter.convert(taskRepository.findByTaskUid(taskUid).orElseThrow(() -> {
            logger.info("Not found task with uid: " + taskUid);
            return new NotFoundTaskException("Not found task with uid: " + taskUid);
        }));
    }

    @Override
    public UUID addTask(AddTaskRequest request) {
        EventEntity event = eventRepository.findByEventUid(request.getEventUid()).orElseThrow(() -> {
            logger.info("Not found event with uid: " + request.getEventUid());
            return new NotFoundEventException("Not found event with uid: " + request.getEventUid());
        });

        TaskEntity task = ModelConverter.convert(request);

        task.setEvent(event);

        return taskRepository.save(task).getTaskUid();
    }

    @Override
    public void linkTaskWithPartner(LinkTaskWithPartnerRequest request) {
        TaskEntity task = taskRepository.findByTaskUid(request.getTaskUid()).orElseThrow(() -> {
            logger.info("Not found task with uid: " + request.getTaskUid());
            return new NotFoundTaskException("Not found task with uid: " + request.getTaskUid());
        });

        task.setPartnerExtId(request.getPartnerExtId());

        taskRepository.save(task);
    }

    @Override
    public void updateTask(UpdateTaskRequest request) {

        TaskEntity task = taskRepository.findByTaskUid(request.getTaskUid()).orElseThrow(() -> {
            logger.info("Not found task with uid: " + request.getTaskUid());
            return new NotFoundTaskException("Not found task with uid: " + request.getTaskUid());
        });

        task.setStatus(request.getStatus());

        taskRepository.save(task);
    }

    @Override
    public List<TaskInfo> getAllTasksByStatus(TaskEnum status) {
        return taskRepository.findAll().stream()
                .filter(task -> task.getStatus() == status)
                .map(ModelConverter::convert)
                .collect(Collectors.toList());
    }
}
