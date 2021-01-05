package com.quizApp.repository;

import com.quizApp.domain.Audit;
import com.quizApp.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shaik on 12/30/16.
 */

@Repository
public interface AuditRepository extends CrudRepository<Audit, Long> {

    @Query("FROM Audit where user_id=?1")
    List<Audit> findByUserId(Long userId);
}
