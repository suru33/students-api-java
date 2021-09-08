package com.suru.students.repositories;


import com.suru.students.domain.entites.Branch;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
public interface BranchRepository extends CrudRepository<Branch, UUID> {

    @Modifying
    @Query(value = """
            UPDATE branch
            SET b_short_name = :#{#branch.shortName}
              , b_name       = :#{#branch.name}
              , b_updated_at = now()
            WHERE b_id = :#{#branch.id}
            """, nativeQuery = true)
    int update(@Param("branch") Branch branch);
}
