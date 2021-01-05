package com.quizApp.repository;

import com.quizApp.domain.Question;
import com.quizApp.domain.SurveyQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shaik on 12/30/16.
 */
@Repository
public interface SurveyQuestionRepository extends CrudRepository<SurveyQuestion, Long> {



}
