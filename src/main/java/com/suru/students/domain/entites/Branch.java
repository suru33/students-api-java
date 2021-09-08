package com.suru.students.domain.entites;


import com.suru.students.domain.responses.BranchResponse;
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
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "branch")
@EntityListeners(AuditingEntityListener.class)
public class Branch {
    @Id
    @Column(name = "b_id", nullable = false)
    @org.hibernate.annotations.Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "b_short_name", length = 10, nullable = false)
    private String shortName;

    @Column(name = "b_name", length = 100, nullable = false)
    private String name;

    @CreatedDate
    @Column(name = "b_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "b_updated_at")
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Branch branch = (Branch) o;
        return Objects.equals(id, branch.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public BranchResponse toDto() {
        BranchResponse branchResponse = new BranchResponse();
        branchResponse.setId(this.getId());
        branchResponse.setShortName(this.getShortName());
        branchResponse.setName(this.getName());
        branchResponse.setCreatedAt(this.getCreatedAt());
        branchResponse.setUpdatedAt(this.getUpdatedAt());
        return branchResponse;
    }
}
