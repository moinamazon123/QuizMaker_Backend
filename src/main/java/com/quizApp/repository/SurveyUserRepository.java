package com.quizApp.repository;

import com.quizApp.domain.Activity;
import com.quizApp.domain.SurveyUser;
import com.quizApp.utility.QuizQueryConstant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by shaik on 12/30/16.
 */

@Repository
public interface SurveyUserRepository extends CrudRepository<SurveyUser, Long> {
    @Query(value= QuizQueryConstant.SURVEY_PARTICIPATE_QRY,nativeQuery = true)
    SurveyUser getSurveyParticipate(@Param("userId") Long userId, @Param("surveyIndex") int surveyIndex);
}
