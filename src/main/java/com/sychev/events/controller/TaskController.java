package com.sychev.events.controller;

import com.sychev.events.model.TaskEnum;
import com.sychev.events.model.request.AddTaskRequest;
import com.sychev.events.model.request.LinkTaskWithPartnerRequest;
import com.sychev.events.model.request.UpdateTaskRequest;
import com.sychev.events.model.response.TaskInfo;
import com.sychev.events.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/tasks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskInfo>> getAllTasks() {
        logger.debug("Getting all tasks");

        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{taskUid}")
    public ResponseEntity<TaskInfo> getTask(@PathVariable UUID taskUid) {
        logger.debug("Getting task with uid: {} ", taskUid);

        return ResponseEntity.ok(taskService.getTask(taskUid));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TaskInfo>> getAllTasksByStatus(@PathVariable TaskEnum status) {
        logger.debug("Getting all task with status: {} ", status);

        return ResponseEntity.ok(taskService.getAllTasksByStatus(status));
    }

    @GetMapping("/event/{eventUid}")
    public ResponseEntity<List<TaskInfo>> getTasksByEvent(@PathVariable UUID eventUid) {
        logger.debug("Getting tasks by event uid: {} ", eventUid);

        return ResponseEntity.ok(taskService.getAllTasksByEvent(eventUid));
    }

    @GetMapping("/person/{prsExtId}")
    public ResponseEntity<List<TaskInfo>> getTasksByPrsExtId(@PathVariable String prsExtId) {
        logger.debug("Getting tasks by person with external id: {} ", prsExtId);

        return ResponseEntity.ok(taskService.getAllTasksByPrsExtId(prsExtId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UUID> addTask(
            @RequestBody @Valid AddTaskRequest request) {
        logger.debug("Adding task with name: {}", request.getName());

        return ResponseEntity.ok(taskService.addTask(request));
    }

    @PostMapping(value = "/link", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> linkTaskAndPartner(@RequestBody @Valid LinkTaskWithPartnerRequest request) {
        logger.debug("Linking task with uid: {} and person with uid: {}", request.getTaskUid(), request.getPartnerExtId());

        taskService.linkTaskWithPartner(request);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<Void> updateTask(@RequestBody @Valid UpdateTaskRequest request) {
        logger.debug("Updating task with uid: {}", request.getTaskUid());

        taskService.updateTask(request);
        return ResponseEntity.ok().build();
    }

}
