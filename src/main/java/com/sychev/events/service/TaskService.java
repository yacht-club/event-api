package com.sychev.events.service;

import com.sychev.events.model.request.AddTaskRequest;
import com.sychev.events.model.response.TaskInfo;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    List<TaskInfo> getAllTasks();

    TaskInfo getTask(UUID taskUid);

    UUID addTask(AddTaskRequest request);
}
