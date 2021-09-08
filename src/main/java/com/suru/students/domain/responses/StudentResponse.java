package com.suru.students.domain.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class StudentResponse {
    private UUID id;
    private String name;
    private UUID branch;
    private Integer year;
    private LocalDate dob;
    private String email;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
