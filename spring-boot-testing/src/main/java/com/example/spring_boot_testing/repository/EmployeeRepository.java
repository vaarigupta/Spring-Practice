package com.example.spring_boot_testing.repository;

import com.example.spring_boot_testing.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
