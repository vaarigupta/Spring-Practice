package com.practice.myapplication.controllers;

import com.practice.myapplication.models.request.CreateTaskRequestModel;
import com.practice.myapplication.models.request.UpdateTaskRequestModel;
import com.practice.myapplication.models.response.Task;
import com.practice.myapplication.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("tasks")
@Validated
public class TaskController {

    //Dependency Injection
    @Autowired
    TaskService taskService;


    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Task> CreateTask(@Valid @RequestBody CreateTaskRequestModel taskRequestModel)
    {

        Task task = taskService.CreateTask(taskRequestModel);
        return new ResponseEntity<Task>(task,HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Task>> GetTask(){

        List<Task> taskList = taskService.GetTask();
        if(!taskList.isEmpty())
        {
            return new ResponseEntity<>(taskList, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(taskList,HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping(path = "{id}" ,
                produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
                })
    public ResponseEntity<Task> GetTaskByID(@PathVariable String id)
    {
        Task task = taskService.GetTaskByID(id);
        if(task!=null)
        {
            return new ResponseEntity<>(task,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(task,HttpStatus.NO_CONTENT);
        }
    }


    @PutMapping(
            path = "{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE,
                         MediaType.APPLICATION_XML_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE,
                         MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Task> UpdateTask(@PathVariable String id, @Valid @RequestBody UpdateTaskRequestModel updateTaskRequestModel)
    {
        Task task = taskService.UpdateTask(id,updateTaskRequestModel);
        if(task!=null)
        {
            return new ResponseEntity<>(task,HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>(task,HttpStatus.NO_CONTENT);
        }
    }


    @DeleteMapping(
            path = "{id}"
    )
    public  ResponseEntity<Void> DeleteTask(@PathVariable String id)
    {
        boolean deleted = taskService.DeleteTask(id);
        if(deleted)
        {
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }

}

//    @RequestParam(value = "page", defaultValue = "1", required = false) int page, //defaultvalue makes the param optional by setting the default value
//    @RequestParam(value = "limit", required = false) Integer limit, //we have used wrapper class for int instead of primitive type because required parameter sets the default value to be null which is not possible in case of primitive data type, only possible with objects
//    @RequestParam(value="sort", defaultValue = "desc") String sort

//        Task t = null;
//        t.setId("1");

//        if(true)
//            throw new TaskServiceException("Task service exception thrown");