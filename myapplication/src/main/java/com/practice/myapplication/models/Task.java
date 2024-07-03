package com.practice.myapplication.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.Date;


public class Task {
    private int id;
    private String name;
    private boolean completed;
    private Date dueBy;

    public Task() {
    }

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.completed = false;
        this.dueBy = Date.from(Instant.now());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getDueBy() {
        return dueBy;
    }

    public void setDueBy(Date dueBy) {
        this.dueBy = dueBy;
    }
}
