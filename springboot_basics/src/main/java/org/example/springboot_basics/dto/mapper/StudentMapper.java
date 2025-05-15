package org.example.springboot_basics.dto.mapper;

import org.example.springboot_basics.dto.request.StudentRequest;
import org.example.springboot_basics.dto.response.StudentResponse;
import org.example.springboot_basics.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentResponse toResponse(Student student) {
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getDob(),
                student.getAverage()
        );
    }

    public Student toEntity(StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setDob(request.getDob());
        student.setAverage(request.getAverage());
        return student;
    }
}
