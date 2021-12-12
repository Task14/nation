package com.example.nation.models.dto.response;

import com.example.nation.models.dto.response.dto.CountryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class CountriesResponseDto {

    private List<CountryDto> countries;
}
