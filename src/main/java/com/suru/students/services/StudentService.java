package com.suru.students.services;

import com.suru.students.domain.entites.Student;
import com.suru.students.domain.requests.StudentRequest;
import com.suru.students.domain.responses.StudentResponse;
import com.suru.students.exceptions.EntityNotfoundException;
import com.suru.students.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentResponse create(StudentRequest request) {
        Student student = repository.save(request.toEntity(UUID.randomUUID()));
        return student.toDto();
    }

    public void update(UUID id, StudentRequest request) throws EntityNotfoundException {
        int update = repository.update(request.toEntity(id));
        if (update != 1) {
            throw new EntityNotfoundException("Student", id);
        }
    }

    public StudentResponse get(UUID id) throws EntityNotfoundException {
        Optional<Student> studentOptional = repository.findById(id);
        if (studentOptional.isPresent()) {
            return studentOptional.get().toDto();
        }
        throw new EntityNotfoundException("Student", id);
    }
}
