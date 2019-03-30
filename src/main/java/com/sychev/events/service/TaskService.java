package com.sychev.events.service;

import com.sychev.events.model.request.AddTaskRequest;
import com.sychev.events.model.request.LinkTaskWithPartnerRequest;
import com.sychev.events.model.request.UpdateTaskRequest;
import com.sychev.events.model.response.TaskInfo;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    List<TaskInfo> getAllTasks();

    List<TaskInfo> getAllTasksByPrsExtId(String prsExtId);

    List<TaskInfo> getAllTasksByEvent(UUID eventUid);

    TaskInfo getTask(UUID taskUid);

    UUID addTask(AddTaskRequest request);

    void linkTaskWithPartner(LinkTaskWithPartnerRequest request);

    void updateTask(UpdateTaskRequest request);
}
