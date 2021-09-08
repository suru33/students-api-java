package com.suru.students.controllers;

import com.suru.students.domain.requests.BranchRequest;
import com.suru.students.domain.responses.BranchResponse;
import com.suru.students.exceptions.EntityNotfoundException;
import com.suru.students.services.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@Controller
@RequestMapping("/branch")
public class BranchController {
    private final BranchService service;

    public BranchController(BranchService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BranchResponse get(@PathVariable UUID id) throws EntityNotfoundException {
        return service.get(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public BranchResponse create(@RequestBody @Validated BranchRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(
            @PathVariable UUID id,
            @RequestBody @Validated BranchRequest request
    ) throws EntityNotfoundException {
        service.update(id, request);
    }
}
