package com.jobseeker.technicaltest.repository;

import com.jobseeker.technicaltest.domain.entity.Candidate;
import com.jobseeker.technicaltest.domain.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends MongoRepository<Candidate, String>  {
    Candidate findByUser(User user);
}
