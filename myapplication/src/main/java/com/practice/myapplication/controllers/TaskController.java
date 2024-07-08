package com.practice.myapplication.controllers;

import com.practice.myapplication.models.request.TaskRequestModel;
import com.practice.myapplication.models.response.Task;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tasks")
@Validated
public class TaskController {


    @GetMapping
    public String GetTask( @RequestParam(value = "page", defaultValue = "1", required = false) int page, //defaultvalue makes the param optional by setting the default value
                                       @RequestParam(value = "limit", required = false) Integer limit, //we have used wrapper class for int instead of primitive type because required parameter sets the default value to be null which is not possible in case of primitive data type, only possible with objects
                                       @RequestParam(value="sort", defaultValue = "desc") String sort)
    {
        return "get tasks for page : " + page + ", limit :" + limit + ", sort : " + sort;
    }

    @GetMapping(path = "/{id}" ,
                produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
                })
    public ResponseEntity<Task> GetTaskByID(@PathVariable String id)
    {
        Task t = new Task();
        t.setId(1);
        t.setName("Work out");
        t.setDesc("Daily for 1 hour");
        t.setCompleted(true);
      //  Task t = new Task(1,"Work out","Daily for 1 hour",true);
        return new ResponseEntity<Task>(t,HttpStatus.OK);
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    public ResponseEntity<Task> CreateTask(@Valid @RequestBody TaskRequestModel taskRequestModel)
    {
        Task t = new Task();
        t.setName(taskRequestModel.getName());
        t.setDesc(taskRequestModel.getDesc());
        t.setCompleted(taskRequestModel.isCompleted());
       // Task t = new Task(1,taskRequestModel.getName(),taskRequestModel.getDesc(),taskRequestModel.isCompleted());
        return new ResponseEntity<Task>(t,HttpStatus.CREATED);
    }

    @PutMapping
    public String UpdateTask()
    {
        return "Update tasks";
    }

    @DeleteMapping
    public  String DeleteTask()
    {
        return "Delete tasks";
    }

}
