package com.jobseeker.technicaltest.domain.entity;

import com.jobseeker.technicaltest.domain.enums.ApplyStatus;
import com.jobseeker.technicaltest.validator.constraint.VacancyExist;
import lombok.Data;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "applicants")
public class Applicant {
    @Id
    private String id;
    @DBRef
    private Vacancy vacancy;
    @DBRef
    private Candidate candidate;
    @CreatedDate
    private Date applyDate;
    private ApplyStatus applyStatus;
}
