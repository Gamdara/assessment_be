package com.jobseeker.technicaltest.service;

import com.jobseeker.technicaltest.domain.entity.Candidate;
import com.jobseeker.technicaltest.domain.entity.User;
import com.jobseeker.technicaltest.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> getCandidate() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateByUser(User user) {
        return candidateRepository.findByUser(user);
    }

    public Candidate getCandidateById(String id) {
        return candidateRepository.findById(id).orElse(null);
    }

    public Candidate saveCandidate(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    public void deleteCandidate(String id){
        candidateRepository.deleteById(id);
    }
}
