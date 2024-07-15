package com.practice.myapplication.shared;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Util {

    public String CreateTaskID()
    {
        return UUID.randomUUID().toString();
    }
}
