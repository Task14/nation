package com.example.nation.models.dto.response.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class CountryStatsResponseDto {

    private Integer id;
    private String name;
    private String countryCode3;
    private Integer year;
    private Double population;
    private Double gdp;
}
