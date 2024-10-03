package com.jobseeker.technicaltest.domain.entity;

import com.jobseeker.technicaltest.domain.enums.VacancyStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "vacancies")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Vacancy{
    @Id
    private String id;
    private String name;
    private int maxAge;
    private Long salary;
    private String description;
    @CreatedDate
    private Date publishDate;
    private Date expiredDate;
    private VacancyStatus status;

}
