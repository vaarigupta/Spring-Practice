package com.practice.myapplication.service;

import com.practice.myapplication.models.request.CreateTaskRequestModel;
import com.practice.myapplication.models.request.UpdateTaskRequestModel;
import com.practice.myapplication.models.response.Task;

import java.util.List;

public interface TaskService {

   Task CreateTask(CreateTaskRequestModel createTaskRequestModel);
   List<Task> GetTask();
   Task GetTaskByID(String id);
   Task UpdateTask(String id, UpdateTaskRequestModel updateTaskRequestModel);
   boolean DeleteTask(String id);
}
