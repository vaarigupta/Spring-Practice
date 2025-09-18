package com.example.spring_boot_testing.repository;

import com.example.spring_boot_testing.model.Employee;
import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployeeObject(){

        //given employee object - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Vaari")
                .lastName("Gupta")
                .email("vaari@gmail.com")
                .build();

        //when - action or the behaviour that we are going to test (save operation)
        Employee savedEmployee = employeeRepository.save(employee);

        //then - verify the output, employee object is saved or not
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);


    }
}
