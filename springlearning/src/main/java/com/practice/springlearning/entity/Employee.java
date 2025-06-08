package com.practice.springlearning.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "employees")
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;

}
