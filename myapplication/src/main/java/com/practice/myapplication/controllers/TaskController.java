package com.practice.myapplication.controllers;

import com.practice.myapplication.models.request.CreateTaskRequestModel;
import com.practice.myapplication.models.request.UpdateTaskRequestModel;
import com.practice.myapplication.models.response.Task;
import jakarta.validation.Valid;
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


    Map<String,Task> taskMap = new HashMap<>();;
    @GetMapping
    public ResponseEntity<List<Task>> GetTask()
    {
        if(!taskMap.isEmpty())
        {
            List<Task> taskList = new ArrayList<>();
            for (Map.Entry<String,Task> entry : taskMap.entrySet())
            {
                taskList.add(entry.getValue());
            }
            return new ResponseEntity<>(taskList, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }


    @GetMapping(path = "{id}" ,
                produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
                })
    public ResponseEntity<Task> GetTaskByID(@PathVariable String id)
    {
        if(taskMap.containsKey(id))
        {
            return new ResponseEntity<>(taskMap.get(id),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE,
                         MediaType.APPLICATION_XML_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE,
                         MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Task> CreateTask(@Valid @RequestBody CreateTaskRequestModel taskRequestModel)
    {
        Task t = new Task();
        t.setName(taskRequestModel.getName());
        t.setDesc(taskRequestModel.getDesc());
        t.setCompleted(taskRequestModel.isCompleted());

        String taskID = UUID.randomUUID().toString();
        t.setId(taskID);

        taskMap.put(taskID,t);
        return new ResponseEntity<Task>(taskMap.get(taskID),HttpStatus.CREATED);
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
        if(taskMap.containsKey(id))
        {
            Task task = taskMap.get(id);
            task.setName(updateTaskRequestModel.getName());
            task.setDesc(updateTaskRequestModel.getDesc());
            taskMap.put(id,task);

            return new ResponseEntity<>(task,HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @DeleteMapping(
            path = "{id}"
    )
    public  ResponseEntity<Void> DeleteTask(@PathVariable String id)
    {
        if(taskMap.containsKey(id))
        {
            taskMap.remove(id);
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }

}

//    @RequestParam(value = "page", defaultValue = "1", required = false) int page, //defaultvalue makes the param optional by setting the default value
//    @RequestParam(value = "limit", required = false) Integer limit, //we have used wrapper class for int instead of primitive type because required parameter sets the default value to be null which is not possible in case of primitive data type, only possible with objects
//    @RequestParam(value="sort", defaultValue = "desc") String sort