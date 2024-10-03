package com.jobseeker.technicaltest.mapper;

import com.jobseeker.technicaltest.domain.dto.vacancy.VacancyDto;
import com.jobseeker.technicaltest.domain.entity.Vacancy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VacancyMapper {
    Vacancy VacancyDtoToVacancy(VacancyDto upsertVacancy);

}
