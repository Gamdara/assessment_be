package com.jobseeker.technicaltest.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Data
@Document(collection = "candidates")
public class Candidate {
    @Id
    private String id;
    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String fullName;
    @Past
    private Date dateOfBirth;
    @NotBlank
    private String placeOfBirth;
    @NotBlank
    private String gender;
    @PositiveOrZero
    private int yearsOfExperience;
    @PositiveOrZero
    private Long lastSalary;
    @DBRef
    @JsonIgnore
    private User user;
}
