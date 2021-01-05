package com.quizApp.repository;

import com.quizApp.domain.SurveyUser;
import com.quizApp.domain.UserQuestionMap;
import com.quizApp.utility.QuizQueryConstant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shaik on 12/30/16.
 */

@Repository
public interface UserQuestionMapRepository extends CrudRepository<UserQuestionMap, Long> {

    @Query(value= QuizQueryConstant.GET_USER_QUESTION_MAP_QRY,nativeQuery = true)
    List<UserQuestionMap> getUserQuestionMap(@Param("userId") Long userId, @Param("quizIndex") int quizIndex);
}
