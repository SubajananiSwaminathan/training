package org.example.springboot_basics;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String name;
    private LocalDate dob;
    private double average;
}
