package org.example.springboot_basics.service;

import org.example.springboot_basics.dto.mapper.StudentMapper;
import org.example.springboot_basics.dto.request.StudentRequest;
import org.example.springboot_basics.dto.response.StudentResponse;
import org.example.springboot_basics.entity.Student;
import org.example.springboot_basics.exception.InvalidDataException;
import org.example.springboot_basics.exception.StudentNotFoundException;
import org.example.springboot_basics.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper mapper;

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<StudentResponse> getAllStudents() {
        List<Student> students = repository.findAll();
        return students.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<StudentResponse> getStudentById(String id) {
        logger.info("Getting student with ID: {}", id);
        return Optional.ofNullable(repository.findById(id)
                .map(student -> {
                    logger.info("Student with ID {} found.", id);
                    return mapper.toResponse(student);
                })
                .orElseThrow(() -> {
                    logger.error("No Student with ID {} found", id);
                    return new StudentNotFoundException("Student with ID " + id + " not found");
                })
        );
    }

    public StudentResponse createStudent(StudentRequest studentRequest) {
        logger.info("Creating new student with name: {}", studentRequest.getName());
        if (studentRequest.getName() == null || studentRequest.getName().isEmpty()) {
            logger.error("Student name cannot be null or empty.");
            throw new InvalidDataException("Student name cannot be null or empty.");
        }
        if (studentRequest.getAverage() < 0) {
            logger.error("Student average must be a non-negative value.");
            throw new InvalidDataException("Student average must be a non-negative value.");
        }
        Student student = mapper.toEntity(studentRequest);
        Student savedStudent = repository.save(student);
        logger.info("Student successfully created with ID: {}", savedStudent.getId());
        return mapper.toResponse(savedStudent);
    }

    public void deleteStudent(String id) {
        logger.info("Deleting student with ID: {}", id);
        Optional<Student> student = repository.findById(id);
        if (student.isEmpty()) {
            logger.error("Student with ID {} not found", id);
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }
        logger.info("Student successfully deleted with ID: {}", id);
        repository.deleteById(id);
    }
}
