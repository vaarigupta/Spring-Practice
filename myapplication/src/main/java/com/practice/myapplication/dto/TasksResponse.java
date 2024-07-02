package com.practice.myapplication.dto;

import com.practice.myapplication.models.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksResponse {
    private int taskCount;
    private List<Task> tasks;
}
