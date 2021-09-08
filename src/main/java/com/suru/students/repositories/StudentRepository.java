package com.suru.students.repositories;

import com.suru.students.domain.entites.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
public interface StudentRepository extends
        CrudRepository<Student, UUID>,
        PagingAndSortingRepository<Student, UUID> {

    @Modifying
    @Query(value = """
            UPDATE student
            SET s_name       = :#{#student.name}
              , s_branch     = :#{#student.branch}
              , s_year       = :#{#student.year}
              , s_dob        = :#{#student.dob}
              , s_email      = :#{#student.email}
              , s_phone      = :#{#student.phone}
              , s_updated_at = now()
            WHERE s_id = :#{#student.id}
            """, nativeQuery = true)
    int update(@Param("student") Student student);

    Page<Student> findAllByBranchAndYear(UUID branch, Integer year, Pageable pageable);

    Page<Student> findAllByBranch(UUID branch, Pageable pageable);

    Page<Student> findAllByYear(Integer year, Pageable pageable);
}
