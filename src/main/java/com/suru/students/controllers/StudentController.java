package com.suru.students.controllers;

import com.suru.students.domain.requests.StudentRequest;
import com.suru.students.domain.responses.StudentResponse;
import com.suru.students.exceptions.EntityNotfoundException;
import com.suru.students.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("student")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse get(@PathVariable UUID id) throws EntityNotfoundException {
        return service.get(id);
    }

    @GetMapping("/all")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Page<StudentResponse> getAll(
            @RequestParam Optional<UUID> branch,
            @RequestParam Optional<Integer> year,
            Pageable pageable
    ) {
        return service.getAll(branch, year, pageable);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse create(@RequestBody @Validated StudentRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(
            @PathVariable UUID id,
            @RequestBody @Validated StudentRequest request
    ) throws EntityNotfoundException {
        service.update(id, request);
    }
}
