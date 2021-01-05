package com.quizApp.repository;

import com.quizApp.domain.Activity;
import com.quizApp.domain.ResponseType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shaik on 12/30/16.
 */

@Repository
public interface ResponseTypeRepository extends CrudRepository<ResponseType, Long> {
}
