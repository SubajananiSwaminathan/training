package org.example.springboot_basics;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public void deleteStudent(String id) {
        repository.deleteById(id);
    }
}
