package com.example.spring_boot_testing.repository;

import com.example.spring_boot_testing.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

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


    //JUnit test for get all employees operation
    @Test
    public void giveEmployeeList_whenFindAll_thenReturnEmployeeList(){

        //given - precondition or setup

        Employee employee = Employee.builder()
                .firstName("Vaari")
                .lastName("Gupta")
                .email("vaari@gmail.com")
                .build();


        Employee employee1 = Employee.builder()
                .firstName("Raavi")
                .lastName("Gupta")
                .email("raavi@gmail.com")
                .build();

        employeeRepository.save(employee);
        employeeRepository.save(employee1);

        //when - action or the behaviour that we are going to test
        List<Employee> employeeList = employeeRepository.findAll();

        //then - verify the output

        assertThat(employeeList).isNotNull();
        assertThat(employeeList).hasSize(2);

    }


        //JUnit test for get employee by id operation
         @Test
         public void giveEmployeeObject_whenFindById_thenReturnEmployeeObject(){

             //given - precondition or setup
             Employee employee = Employee.builder()
                     .firstName("Vaari")
                     .lastName("Gupta")
                     .email("vaari@gmail.com")
                     .build();

             employeeRepository.save(employee);

             //when - action or the behaviour that we are going to test
             Employee savedEmployee = employeeRepository.findById(employee.getId()).get();

             //then - verify the output
             assertThat(employee).isNotNull();
             assertThat(employee.getId()).isGreaterThan(0);
         }

          //JUnit test for find by email operation
          @Test
          public void giveEmployeeObject_whenFindByEmail_thenReturnEmployeeObject(){

              //given - precondition or setup
              Employee employee = Employee.builder()
                      .firstName("Vaari")
                      .lastName("Gupta")
                      .email("vaari@gmail.com")
                      .build();

              employeeRepository.save(employee);

              //when - action or the behaviour that we are going to test
              Employee savedEmployee = employeeRepository.findByEmail(employee.getEmail()).get();

              //then - verify the output
              assertThat(savedEmployee).isNotNull();
          }
}
