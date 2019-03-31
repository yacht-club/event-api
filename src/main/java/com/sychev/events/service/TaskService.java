package com.sychev.events.service;

import com.sychev.events.model.TaskEnum;
import com.sychev.events.model.request.AddTaskRequest;
import com.sychev.events.model.request.LinkTaskWithPartnerRequest;
import com.sychev.events.model.request.UpdateTaskRequest;
import com.sychev.events.model.response.TaskInfo;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface TaskService {

    List<TaskInfo> getAllTasks();

    List<TaskInfo> getAllTasksByPrsExtId(String prsExtId);

    List<TaskInfo> getAllTasksByEvent(UUID eventUid);

    List<TaskInfo> getAllTasksByStatus(TaskEnum status);

    TaskInfo getTask(UUID taskUid);

    UUID addTask(AddTaskRequest request, String email, String url);

    void linkTaskWithPartner(LinkTaskWithPartnerRequest request);

    void updateTask(UpdateTaskRequest request);
}
