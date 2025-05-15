package org.example.springboot_basics.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class StudentRequest {
    private String name;
    private Date dob;
    private double average;
}
