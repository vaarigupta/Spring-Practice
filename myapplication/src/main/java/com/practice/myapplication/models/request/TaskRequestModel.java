package com.practice.myapplication.models.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskRequestModel {

    @NotNull(message =  "name cannot be null")
    @Size(min=3, max=20,message="size must be greater or equal to 3 but less than or equal to 20")
    private String name;
    private String desc;
    private boolean completed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
