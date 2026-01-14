package com.example.spring_boot_testing.repository;

import com.example.spring_boot_testing.model.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @DisplayName("Test to create Employee")
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
    @DisplayName("Test to get All Employees")
    @Test
    public void givenEmployeeList_whenFindAll_thenReturnEmployeeList(){

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
    @DisplayName("Test to get Employee by Id")
     @Test
     public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject(){

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
         assertThat(savedEmployee).isNotNull();
         assertThat(savedEmployee.getId()).isGreaterThan(0);
     }

      //JUnit test for find by email operation
      @DisplayName("Test to get Employee by Email")
      @Test
      public void givenEmployeeObject_whenFindByEmail_thenReturnEmployeeObject(){

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

        //JUnit test to Update Employee operation
       @DisplayName("Test to Update Employee")
       @Test
       public void givenEmployeeObject_whenUpdateEmployee_thenUpdateEmployeeObject(){

       //given - precondition or setup
       Employee employee = Employee.builder()
               .firstName("Vaari")
               .lastName("Gupta")
               .email("vaarigupta@gmail.com")
               .build();

       employeeRepository.save(employee);
       Employee savedEmployee = employeeRepository.findById(employee.getId()).get();

       //when - action or the behaviour that we are going to test
       //updating the employee object
       savedEmployee.setFirstName("Raavi");
       savedEmployee.setEmail("raavigupta@gmail.com");
       employeeRepository.save(savedEmployee);
       Employee updatedEmployee = employeeRepository.findById(employee.getId()).get();

       //then - verify the output
       assertThat(updatedEmployee.getFirstName()).isEqualTo("Raavi");
       assertThat(updatedEmployee.getEmail()).isEqualTo("raavigupta@gmail.com");

   }

    //JUnit test for Delete employee operation
    @DisplayName("Test to Delete Employee")
    @Test
    public void givenEmployeeObject_whenDeleted_thenNoEmployeeObject(){

       //given - precondition or setup
       Employee employee = Employee.builder()
               .firstName("Vaari")
               .lastName("Gupta")
               .email("vaari@gmail.com")
               .build();

       employeeRepository.save(employee);

       //when - action or the behaviour that we are going to test
       employeeRepository.delete(employee);
       Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());

       //then - verify the output
       assertThat(employeeOptional).isEmpty();
    }

   //JUnit test for Delete employee operation
    @DisplayName("Test to Delete Employee by Id")
    @Test
    public void givenEmployeeObject_whenDeletedById_thenNoEmployeeObject(){

        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Vaari")
                .lastName("Gupta")
                .email("vaari@gmail.com")
                .build();

        employeeRepository.save(employee);

        //when - action or the behaviour that we are going to test
        employeeRepository.deleteById(employee.getId());
        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());

        //then - verify the output
        assertThat(employeeOptional).isEmpty();
    }

        //JUnit test for Custom query using JPQL with index params
         @DisplayName("Test to get Employee using custom query with JPQL with index params")
         @Test
         public void givenEmployeeObject_whenFindByCustomQueryUsingJPQLIndexParams_thenReturnEmployeeObject(){

             //given - precondition or setup
             Employee employee = Employee.builder()
                     .firstName("Vaari")
                     .lastName("Gupta")
                     .email("vaarigupta@gmail.com")
                     .build();

              employeeRepository.save(employee);

             //when - action or the behaviour that we are going to test
             Employee foundEmployee = employeeRepository.findByJPQL(employee.getFirstName(),employee.getLastName());

             //then - verify the output
             assertThat(foundEmployee).isNotNull();
         }

    //JUnit test for Custom query using JPQL with index params
    @DisplayName("Test to get Employee using custom query with JPQL with named params")
    @Test
    public void givenEmployeeObject_whenFindByCustomQueryUsingJPQLNamedParams_thenReturnEmployeeObject(){

        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Vaari")
                .lastName("Gupta")
                .email("vaarigupta@gmail.com")
                .build();

        employeeRepository.save(employee);

        //when - action or the behaviour that we are going to test
        Employee foundEmployee = employeeRepository.findByJPQLNamedParams(employee.getFirstName(),employee.getLastName());

        //then - verify the output
        assertThat(foundEmployee).isNotNull();
    }
}
