package com.example.nation.models.dto.response.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class CountryDto {

    private Integer id;
    private String name;
    private RegionDto region;
    private String countryCode2;
}
