package com.suru.students.domain.requests;

import com.suru.students.domain.entites.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class StudentRequest {
    @NotNull(message = "Student name is mandatory")
    @Size(
            min = 2,
            max = 100,
            message = "Student name '${validatedValue}' must be between {min} and {max} characters long"
    )
    private String name;

    @NotNull(message = "Not a valid branch id")
    private UUID branch;

    @NotNull(message = "Year is mandatory")
    @Min(value = 1, message = "Year should be in (1, 2, 3, 4)")
    @Max(value = 4, message = "Year should be in (1, 2, 3, 4)")
    private Integer year;

    @NotNull(message = "Dob is mandatory")
    private LocalDate dob;

    @NotNull(message = "Email is mandatory")
    @Size(
            min = 5,
            max = 100,
            message = "Email '${validatedValue}' must be between {min} and {max} characters long"
    )
    private String email;

    @NotNull(message = "Phone is mandatory")
    @Size(max = 20, message = "Phone '${validatedValue}' must be between {min} and {max} characters long")
    private String phone;

    public Student toEntity(UUID id) {
        Student student = new Student();
        student.setId(id);
        student.setName(this.getName());
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
