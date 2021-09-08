package com.suru.students.services;

import com.suru.students.domain.entites.Branch;
import com.suru.students.domain.requests.BranchRequest;
import com.suru.students.domain.responses.BranchResponse;
import com.suru.students.exceptions.EntityNotfoundException;
import com.suru.students.repositories.BranchRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BranchService {
    private final BranchRepository repository;

    public BranchService(BranchRepository repository) {
        this.repository = repository;
    }

    public BranchResponse create(BranchRequest request) {
        Branch branch = repository.save(request.toEntity(UUID.randomUUID()));
        return branch.toDto();
    }

    public void update(UUID id, BranchRequest request) throws EntityNotfoundException {
        int update = repository.update(request.toEntity(id));
        if(update != 1) {
            throw new EntityNotfoundException("Branch", id);
        }
    }

    public BranchResponse get(UUID id) throws EntityNotfoundException {
        Optional<Branch> optionalBranch = repository.findById(id);
        if (optionalBranch.isPresent()) {
            return optionalBranch.get().toDto();
        }
        throw new EntityNotfoundException("Branch", id);
    }

}
