package com.practice.myapplication.service;

import com.practice.myapplication.models.request.CreateTaskRequestModel;
import com.practice.myapplication.models.request.UpdateTaskRequestModel;
import com.practice.myapplication.models.response.Task;
import com.practice.myapplication.shared.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskServiceImpl implements TaskService{

    Map<String,Task> taskMap = new HashMap<>();
    Util util;

    public  TaskServiceImpl(){}

    //Constructor based dependency injection
    @Autowired
    public TaskServiceImpl(Util util)
    {
        this.util = util;
    }


    @Override
    public Task CreateTask(CreateTaskRequestModel taskRequestModel) {
        Task task = new Task();
        task.setName(taskRequestModel.getName());
        task.setDesc(taskRequestModel.getDesc());
        task.setCompleted(taskRequestModel.isCompleted());

        String taskID = util.CreateTaskID();
        task.setId(taskID);

        taskMap.put(taskID, task);
        return task;
    }


    public List<Task> GetTask()
    {
        List<Task> taskList = new ArrayList<>();
        if(!taskMap.isEmpty()) {
            for (Map.Entry<String,Task> entry : taskMap.entrySet()) {
                taskList.add(entry.getValue());
            }
            return taskList;
        }
        else {
            return taskList;
        }
    }

    public Task GetTaskByID(String id)
    {
        if(taskMap.containsKey(id)) {
            return taskMap.get(id);
        }
        else {
            return null;
        }
    }

    public Task UpdateTask(String id, UpdateTaskRequestModel updateTaskRequestModel)
    {
        if(taskMap.containsKey(id))
        {
            Task task = taskMap.get(id);
            task.setName(updateTaskRequestModel.getName());
            task.setDesc(updateTaskRequestModel.getDesc());
            taskMap.put(id,task);
            return task;
        }
        else {
            return null;
        }
    }

    public boolean DeleteTask(String id)
    {
        if(taskMap.containsKey(id)) {
            taskMap.remove(id);
            return true;
        }
        return false;
    }
}
