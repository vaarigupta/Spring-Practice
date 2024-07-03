package com.practice.myapplication.controllers;

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
    public String GetTaskByPagination( @RequestParam(value = "page") int page,
                                       @RequestParam(value = "limit") int limit)
    {
        return "get tasks for page : " + page + " and limit :" + limit;
    }

    @GetMapping(path = "/{id}")
    public String GetTaskByID(@PathVariable String id)
    {
        return "get task for ID : " + id;
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
