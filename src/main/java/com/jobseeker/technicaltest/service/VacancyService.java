package com.jobseeker.technicaltest.service;

import com.jobseeker.technicaltest.domain.entity.Vacancy;
import com.jobseeker.technicaltest.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class VacancyService {
    @Autowired
    private VacancyRepository vacancyRepository;

    public Page<Vacancy> getVacancies(String name, Pageable pageable) {
        return vacancyRepository.findByNameContainsIgnoreCase(name, pageable);
    }

    public Optional<Vacancy> getVacancyByIdOptional(String id) {
        return vacancyRepository.findById(id);
    }

    public Vacancy getVacancyById(String id) {
        return vacancyRepository.findById(id).orElse(null);
    }

    public Vacancy saveVacancy(Vacancy vacancy){
        return vacancyRepository.save(vacancy);
    }

    public void deleteVacancy(String id){
        vacancyRepository.deleteById(id);
    }
}
