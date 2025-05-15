package org.example.springboot_basics.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class StudentResponse {
    private String id;
    private String name;
    private Date dob;
    private double average;

    public StudentResponse(String id, String name, Date dob, double average) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.average = average;
    }
}
