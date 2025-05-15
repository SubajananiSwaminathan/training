package org.example.springboot_basics.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String name;
    private Date dob;
    private double average;
}
