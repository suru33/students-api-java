package com.suru.students.domain.entites;

import com.suru.students.domain.responses.StudentResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
public class Student {

    @Id
    @Column(name = "s_id", nullable = false)
    @org.hibernate.annotations.Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "s_name", length = 100, nullable = false)
    private String name;

    @Column(name = "s_branch", nullable = false)
    @org.hibernate.annotations.Type(type = "pg-uuid")
    private UUID branch;

    @Column(name = "s_year", nullable = false)
    private Integer year;

    @Column(name = "s_dob", nullable = false)
    private LocalDate dob;

    @Column(name = "s_email", length = 100, nullable = false)
    private String email;

    @Column(name = "s_phone", length = 20, nullable = false)
    private String phone;

    @CreatedDate
    @Column(name = "s_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "s_updated_at")
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public StudentResponse toDto() {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(this.getId());
        studentResponse.setName(this.getName());
        studentResponse.setBranch(this.getBranch());
        studentResponse.setYear(this.getYear());
        studentResponse.setDob(this.getDob());
        studentResponse.setEmail(this.getEmail());
        studentResponse.setPhone(this.getPhone());
        studentResponse.setCreatedAt(LocalDateTime.now());
        studentResponse.setUpdatedAt(LocalDateTime.now());
        return studentResponse;
    }
}
