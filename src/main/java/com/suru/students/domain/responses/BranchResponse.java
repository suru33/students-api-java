package com.suru.students.domain.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class BranchResponse {
    private UUID id;
    private String shortName;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
