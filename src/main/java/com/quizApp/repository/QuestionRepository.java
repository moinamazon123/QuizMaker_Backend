package com.quizApp.repository;

import com.quizApp.domain.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shaik on 12/30/16.
 */
@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {



}
