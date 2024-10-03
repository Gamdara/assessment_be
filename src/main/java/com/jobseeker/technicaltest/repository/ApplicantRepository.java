package com.jobseeker.technicaltest.repository;

import com.jobseeker.technicaltest.domain.entity.Applicant;
import com.jobseeker.technicaltest.domain.entity.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ApplicantRepository extends MongoRepository<Applicant, String> ,  PagingAndSortingRepository<Applicant, String> {
    Page<Applicant> findAllByApplyStatusContainsIgnoreCase(String search, Pageable pageable);
    Page<Applicant> findAllByCandidateAndApplyStatusContainsIgnoreCase(Candidate candidate, String search,  Pageable pageable);
    Optional<Applicant> findByVacancyIdAndCandidateId(String vacancyId, String candidateId);
}
