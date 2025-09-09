package com.practice.springlearning.service.impl;

import com.practice.springlearning.dto.EmployeeDto;
import com.practice.springlearning.entity.Employee;
import com.practice.springlearning.mapper.EmployeeMapper;
import com.practice.springlearning.repository.EmployeeRepository;
import com.practice.springlearning.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

//    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    } //dependency injection via constructor

    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {

        //Convert EmployeeDto to Employee entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Mono<Employee> savedEmployeeEntity = employeeRepository.save(employee);
        //Convert Employee entity to EmployeeDto
        return savedEmployeeEntity
                .map((employeeEntity) -> EmployeeMapper.mapToEmployeeDto(employeeEntity));
    }
}
