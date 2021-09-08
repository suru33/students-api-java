package com.suru.students.domain.requests;

import com.suru.students.domain.entites.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class StudentRequest {
    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    private UUID branch;

    @NotNull
    @Min(1)
    @Min(4)
    private Integer year;

    @NotNull
    private LocalDate dob;

    @NotNull
    @Size(max = 100)
    private String email;

    @NotNull
    @Size(max = 20)
    private String phone;

    public Student toEntity(UUID id) {
        Student student = new Student();
        student.setId(id);
        student.setBranch(this.getBranch());
        student.setYear(this.getYear());
        student.setDob(this.getDob());
        student.setEmail(this.getEmail());
        student.setPhone(this.getPhone());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return student;
    }
}
