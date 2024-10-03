package com.jobseeker.technicaltest.controller;

import com.jobseeker.technicaltest.domain.dto.response.ApiResponse;
import com.jobseeker.technicaltest.domain.dto.response.DatatablesResponseDto;
import com.jobseeker.technicaltest.domain.dto.vacancy.VacancyDto;
import com.jobseeker.technicaltest.domain.entity.Vacancy;
import com.jobseeker.technicaltest.exceptions.ObjectNotFoundException;
import com.jobseeker.technicaltest.mapper.VacancyMapper;
import com.jobseeker.technicaltest.service.VacancyService;
import com.jobseeker.technicaltest.validator.constraint.VacancyUnique;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vacancies")
public class VacancyController {
    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private VacancyMapper vacancyMapper;

    @GetMapping
    ResponseEntity<DatatablesResponseDto> getVacancies(
            @RequestParam(defaultValue = "0") int draw,
            @RequestParam(defaultValue = "0") int start,
            @RequestParam(defaultValue = "10") int length,
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "id") String orderCol,
            @RequestParam(defaultValue = "asc") String orderDir
            ) {

        Pageable pageable = PageRequest.of(start / length, length, Sort.by(orderDir.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, orderCol));

        Page<Vacancy> vacancies = vacancyService.getVacancies(search, pageable);

        DatatablesResponseDto responseDto = new DatatablesResponseDto(
               draw,  vacancies.getNumberOfElements(), vacancies.getTotalElements(), vacancies.getContent()
        );
        return ResponseEntity.ok(responseDto);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    ApiResponse<Vacancy> createVacancy(@RequestBody @Valid @VacancyUnique VacancyDto vacancyDto) {
        System.out.println(vacancyDto.getStatus());

        Vacancy vacancy = vacancyMapper.VacancyDtoToVacancy(vacancyDto);
        System.out.println(vacancy);
        Vacancy newVacancy = vacancyService.saveVacancy(vacancy);
        return new ApiResponse<Vacancy>(true, "OK", newVacancy);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{id}")
    ApiResponse<Vacancy> updateVacancy( @Valid @RequestBody VacancyDto vacancyDto, @PathVariable String id) throws ObjectNotFoundException {
        Vacancy oldVacancy = vacancyService.getVacancyByIdOptional(id).orElseThrow(() -> new ObjectNotFoundException("Vacancy Not found"));
        Vacancy vacancy = vacancyMapper.VacancyDtoToVacancy(vacancyDto);
        vacancy.setId(id);
        vacancy.setPublishDate(oldVacancy.getPublishDate());
        Vacancy newVacancy = vacancyService.saveVacancy(vacancy);
        return new ApiResponse<Vacancy>(true, "OK", newVacancy);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    ApiResponse deleteVacancy(@PathVariable String id) throws ObjectNotFoundException {
        Vacancy oldVacancy = vacancyService.getVacancyByIdOptional(id).orElseThrow(() -> new ObjectNotFoundException("Vacancy Not found"));
        vacancyService.deleteVacancy(id);
        return new ApiResponse<>(true, "OK", null);
    }

}
