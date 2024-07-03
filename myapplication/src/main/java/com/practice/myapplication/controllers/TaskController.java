package com.practice.myapplication.controllers;

import com.practice.myapplication.models.Task;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @GetMapping("/all")
    public String GetTask()
    {
        return "get tasks";
    }

    @GetMapping
    public String GetTaskByPagination( @RequestParam(value = "page", defaultValue = "1", required = false) int page, //defaultvalue makes the param optional by setting the default value
                                       @RequestParam(value = "limit", required = false) Integer limit, //we have used wrapper class for int instead of primitive type because required parameter sets the default value to be null which is not possible in case of primitive data type, only possible with objects
                                       @RequestParam(value="sort", defaultValue = "desc") String sort)
    {
        return "get tasks for page : " + page + ", limit :" + limit + ", sort : " + sort;
    }

    @GetMapping(path = "/{id}")
    public Task GetTaskByID(@PathVariable String id)
    {
        Task t = new Task(1,"Work out");
        return t;
    }

    @PostMapping
    public String CreateTask()
    {
        return "post tasks";
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
