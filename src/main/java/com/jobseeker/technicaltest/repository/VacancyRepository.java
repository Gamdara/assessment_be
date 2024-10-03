package com.jobseeker.technicaltest.repository;

import com.jobseeker.technicaltest.domain.entity.Vacancy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VacancyRepository extends MongoRepository<Vacancy, String>, PagingAndSortingRepository<Vacancy, String> {

    Page<Vacancy> findByNameContainsIgnoreCase(String name, Pageable pageable);
    Optional<Vacancy> findByName(String name);
}
