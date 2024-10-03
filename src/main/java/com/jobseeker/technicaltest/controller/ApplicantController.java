package com.jobseeker.technicaltest.controller;

import com.jobseeker.technicaltest.domain.dto.response.ApiResponse;
import com.jobseeker.technicaltest.domain.dto.applicant.ApplicantDto;
import com.jobseeker.technicaltest.domain.dto.response.DatatablesResponseDto;
import com.jobseeker.technicaltest.domain.entity.Applicant;
import com.jobseeker.technicaltest.domain.entity.Candidate;
import com.jobseeker.technicaltest.domain.entity.User;
import com.jobseeker.technicaltest.domain.enums.Role;
import com.jobseeker.technicaltest.exceptions.ObjectNotFoundException;
import com.jobseeker.technicaltest.mapper.ApplicantMapper;
import com.jobseeker.technicaltest.service.ApplicantService;
import com.jobseeker.technicaltest.service.CandidateService;
import com.jobseeker.technicaltest.validator.constraint.ApplicantUnique;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/applicants")
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private ApplicantMapper applicantMapper;


    @GetMapping
    ResponseEntity<DatatablesResponseDto> getApplicant(
            @RequestParam(defaultValue = "0") int draw,
            @RequestParam(defaultValue = "0") int start,
            @RequestParam(defaultValue = "10") int length,
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "id") String orderCol,
            @RequestParam(defaultValue = "asc") String orderDir
    ) {
        Pageable pageable = PageRequest.of(start / length, length, Sort.by(orderDir.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, orderCol));

        Page<Applicant> applicants;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        if (currentUser.getRole().equals(Role.ROLE_CANDIDATE)){
            Candidate candidate = candidateService.getCandidateByUser(currentUser);
            applicants = applicantService.getApplicantByCandidate(candidate, search, pageable);
        }
        else{
            applicants = applicantService.getApplicant(search, pageable);
        }

        DatatablesResponseDto responseDto = new DatatablesResponseDto(
                draw,  applicants.getNumberOfElements(), applicants.getTotalElements(), applicants.getContent()
        );

        return ResponseEntity.ok(responseDto);

    }

    @Secured("ROLE_CANDIDATE")
    @PostMapping
    ApiResponse<Applicant> createApplicant(@RequestBody @Valid @ApplicantUnique ApplicantDto applicantDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        Candidate candidate = candidateService.getCandidateByUser(currentUser);
        applicantDto.setCandidateId(candidate.getId());

        Applicant applicant = applicantMapper.ApplicantDtoToApplicant(applicantDto);

        Applicant newApplicant = applicantService.saveApplicant(applicant);
        return new ApiResponse<Applicant>(true, "Create success", newApplicant);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{id}")
    ApiResponse<Applicant> updateApplicant(@RequestBody ApplicantDto applicantDto, @PathVariable String id) throws ObjectNotFoundException  {
        Applicant oldApplicant = applicantService.getApplicantById(id).orElseThrow(() -> new ObjectNotFoundException("Applicant Not found"));
        oldApplicant.setApplyStatus(applicantDto.getApplyStatus());
        Applicant newApplicant = applicantService.saveApplicant(oldApplicant);
        return new ApiResponse<Applicant>(true, "Update Success", newApplicant);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    ApiResponse deleteApplicant(@PathVariable String id) throws ObjectNotFoundException {
        applicantService.getApplicantById(id).orElseThrow(() -> new ObjectNotFoundException("Applicant Not found"));
        applicantService.deleteApplicant(id);
        return new ApiResponse<>(true, "Delete success", null);
    }
}
