package com.quizApp.repository;

import com.quizApp.domain.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shaik on 12/30/16.
 */

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {
}
