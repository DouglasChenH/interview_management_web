package com.douglas.interview_management.repository;

import com.douglas.interview_management.models.Interview;
import org.springframework.data.repository.CrudRepository;



public interface InterviewRepository extends CrudRepository<Interview, String> {
    @Override
    Interview findOne(String id);

    @Override
    void delete(Interview deleted);
}