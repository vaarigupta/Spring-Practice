package com.practice.myapplication.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @GetMapping
    public String GetTask()
    {
        return "get tasks";
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
