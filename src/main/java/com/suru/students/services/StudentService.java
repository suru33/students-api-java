package com.suru.students.services;

import com.suru.students.domain.entites.Student;
import com.suru.students.domain.requests.StudentRequest;
import com.suru.students.domain.responses.StudentResponse;
import com.suru.students.exceptions.EntityNotfoundException;
import com.suru.students.repositories.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<StudentResponse> getAll(Optional<UUID> branch, Optional<Integer> year, Pageable pageable) {
        if (branch.isPresent() && year.isPresent()) {
            return repository.findAllByBranchAndYear(branch.get(), year.get(), pageable).map(Student::toDto);
        } else if (branch.isPresent()) {
            return repository.findAllByBranch(branch.get(), pageable).map(Student::toDto);
        } else if (year.isPresent()) {
            return repository.findAllByYear(year.get(), pageable).map(Student::toDto);
        }

        return repository.findAll(pageable).map(Student::toDto);
    }
}
