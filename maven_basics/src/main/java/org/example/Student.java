package org.example;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class Student {
    private int id;
    private String name;
    private int age;
    private List<String> subjects;
}
