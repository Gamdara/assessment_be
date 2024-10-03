package com.jobseeker.technicaltest.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DatatablesResponseDto {
    private int draw;
    private int recordsFiltered;
    private long recordsTotal;

    private List<?> data;
}
