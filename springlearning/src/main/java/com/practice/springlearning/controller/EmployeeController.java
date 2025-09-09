package com.practice.springlearning.controller;

import com.practice.springlearning.dto.EmployeeDto;
import com.practice.springlearning.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

// This class will handle HTTP requests related to Employee operations
// You can define methods here to handle GET, POST, PUT, DELETE requests
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {


    private EmployeeService employeeService;
    //Build Reactive REST API for Employee operations
    // You can add methods here to handle various HTTP requests like GET, POST, PUT, DELETE
    //Save the employee using the EmployeeService

    @PostMapping("/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }


}
