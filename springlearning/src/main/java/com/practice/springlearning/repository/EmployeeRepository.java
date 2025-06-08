package com.practice.springlearning.repository;

import com.practice.springlearning.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {
    // Additional query methods can be defined here if needed
}
