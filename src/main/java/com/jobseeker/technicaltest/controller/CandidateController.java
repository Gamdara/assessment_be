package com.jobseeker.technicaltest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/candidates")
public class CandidateController {
//    @Autowired
//    private CandidateService candidateService;
//    @Autowired
//    private CandidateMapper candidateMapper;


//    @GetMapping
//    ApiResponse<List<Candidate>> getCandidate() {
//        List<Candidate> vacancies = candidateService.getCandidate();
//        return new ApiResponse<List<Candidate>>(true, "OK", vacancies);
//    }
//
//    @PostMapping
//    ApiResponse<Candidate> createCandidate(@RequestBody @Valid CandidateDto candidateDto) {
//        Candidate candidate = candidateMapper.CandidateDtoToCandidate(candidateDto);
//        Candidate newCandidate = candidateService.saveCandidate(candidate);
//        return new ApiResponse<Candidate>(true, "OK", newCandidate);
//    }
//
//
//    @DeleteMapping("/{id}")
//    ApiResponse deleteCandidate(@PathVariable String id) {
//        candidateService.deleteCandidate(id);
//        return new ApiResponse<>(true, "OK", null);
//    }
}
