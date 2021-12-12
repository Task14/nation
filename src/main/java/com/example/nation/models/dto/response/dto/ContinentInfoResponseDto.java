package com.example.nation.models.dto.response.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ContinentInfoResponseDto {

    private String continentName;
    private String regionName;
    private String countryName;
    private Integer year;
    private Double population;
    private Double gdp;
}
