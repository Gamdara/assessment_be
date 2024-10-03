package com.jobseeker.technicaltest.service;

import com.jobseeker.technicaltest.domain.entity.Applicant;
import com.jobseeker.technicaltest.domain.entity.Candidate;
import com.jobseeker.technicaltest.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicantService {
    @Autowired
    private ApplicantRepository applicantRepository;

    public Page<Applicant> getApplicant(String search, Pageable pageable) {
        return applicantRepository.findAllByApplyStatusContainsIgnoreCase(search,pageable);
    }

    public Page<Applicant> getApplicantByCandidate(Candidate candidate,String search, Pageable pageable) {
        return applicantRepository.findAllByCandidateAndApplyStatusContainsIgnoreCase(candidate,search, pageable);
    }

    public Optional<Applicant> getApplicantById(String id) {
        return applicantRepository.findById(id);
    }

    public Applicant saveApplicant(Applicant applicant){
        return applicantRepository.save(applicant);
    }

    public void deleteApplicant(String id){
        applicantRepository.deleteById(id);
    }

}
