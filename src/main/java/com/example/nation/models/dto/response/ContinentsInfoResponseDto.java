package com.example.nation.models.dto.response;

import com.example.nation.models.dto.response.dto.ContinentInfoResponseDto;
import com.example.nation.models.dto.response.dto.CountryStatsResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ContinentsInfoResponseDto {

    private List<ContinentInfoResponseDto> continentInfoResponseDtoList;
}
