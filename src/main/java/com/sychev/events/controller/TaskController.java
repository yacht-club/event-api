package com.sychev.events.controller;

import com.sychev.events.model.request.AddTaskRequest;
import com.sychev.events.model.response.TaskInfo;
import com.sychev.events.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UUID> addTask(@RequestBody @Valid AddTaskRequest request) {
        logger.debug("Adding task with name: {}", request.getName());

        return ResponseEntity.ok(taskService.addTask(request));
    }

}
