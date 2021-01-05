package com.quizApp.repository;

import com.quizApp.domain.security.Role;
import com.quizApp.domain.security.UserRole;
import com.quizApp.utility.QuizQueryConstant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by shaik on 12/21/16.
 */
@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {

    @Query(value= QuizQueryConstant.DELETE_EXISTING_ROLE_BY_ID,nativeQuery = true)
    @Modifying
    void deleteRoleByUserId(@Param("userId") Long userId);

}
