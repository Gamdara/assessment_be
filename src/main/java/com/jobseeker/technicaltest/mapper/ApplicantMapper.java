package com.jobseeker.technicaltest.mapper;

import com.jobseeker.technicaltest.domain.dto.applicant.ApplicantDto;
import com.jobseeker.technicaltest.domain.entity.Applicant;
import com.jobseeker.technicaltest.service.CandidateService;
import com.jobseeker.technicaltest.service.VacancyService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {VacancyService.class, CandidateService.class})
public interface ApplicantMapper {
    @Mapping(source = "vacancyId", target = "vacancy")
    @Mapping(source = "candidateId", target = "candidate")
    Applicant ApplicantDtoToApplicant(ApplicantDto applicantDto);

}
