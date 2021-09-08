package com.suru.students.domain.requests;

import com.suru.students.domain.entites.Branch;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class BranchRequest {
    @NotNull
    @Size(
            min = 2,
            max = 10,
            message = "Shot name '${validatedValue}' must be between {min} and {max} characters long"
    )
    private String shortName;

    @NotNull
    @Size(
            min = 2,
            max = 100,
            message = "Name '${validatedValue}' must be between {min} and {max} characters long"
    )
    private String name;

    public Branch toEntity(UUID id) {
        Branch branch = new Branch();
        branch.setId(id);
        branch.setShortName(this.getShortName());
        branch.setName(this.getName());
        branch.setCreatedAt(LocalDateTime.now());
        branch.setUpdatedAt(LocalDateTime.now());
        return branch;
    }
}
