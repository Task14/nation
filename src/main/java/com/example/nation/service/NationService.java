package com.example.nation.service;

import com.example.nation.models.dto.response.ContinentsInfoResponseDto;
import com.example.nation.models.dto.response.CountriesResponseDto;
import com.example.nation.models.dto.response.CountriesStatsResponseDto;
import com.example.nation.models.dto.response.CountryDetailsResponseDto;
import com.example.nation.models.dto.response.dto.*;
import com.example.nation.models.entities.ContinentsEntity;
import com.example.nation.models.entities.CountriesEntity;
import com.example.nation.models.entities.CountryStatsEntity;
import com.example.nation.models.entities.RegionsEntity;
import com.example.nation.repository.CountryRepository;
import com.example.nation.repository.CountryStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NationService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryStatsRepository countryStatsRepository;

    public CountriesResponseDto getCountries() {
        List<CountriesEntity> countries = (List<CountriesEntity>) countryRepository.findAll();
        return CountriesResponseDto.builder().countries(countries
                .stream()
                .map(this::countryToDto)
                .collect(Collectors.toList()))
                .build();
    }

    public CountryDetailsResponseDto getCountry(Integer id) {
        Optional<CountriesEntity> country = countryRepository.findById(id);
        return country.isPresent() ? countryToDetailsDto(country.get()) : CountryDetailsResponseDto.builder().build();
    }

    public CountriesStatsResponseDto getCountriesStats() {
        List<CountriesEntity> countries = (List<CountriesEntity>) countryRepository.findAll();
        List<CountryStatsResponseDto> countryStatsResponseDtoList = countries
                .stream()
                .map(this::countryToStatsResponseDto)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return CountriesStatsResponseDto.builder()
                .countryStatsResponseDtos(countryStatsResponseDtoList)
                .build();
    }

    public ContinentsInfoResponseDto getContinentsInfo() {
        List<CountriesEntity> countries = (List<CountriesEntity>) countryRepository.findAll();

        List<ContinentInfoResponseDto> continentInfoResponseDtoList =  countries
                .stream()
                .map(this::countryToContinentInfoResponseDto)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return ContinentsInfoResponseDto.builder()
                .continentInfoResponseDtoList(continentInfoResponseDtoList)
                .build();
    }

    private CountryDto countryToDto(CountriesEntity country) {
        return CountryDto.builder()
                .id(country.getCountryId())
                .name(country.getName())
                .region(RegionDto.builder().name(country.getRegionsByRegionId().getName()).build())
                .countryCode2(country.getCountryCode2())
                .build();
    }

    private CountryDetailsResponseDto countryToDetailsDto(CountriesEntity country) {
        return CountryDetailsResponseDto.builder()
                .name(country.getName())
                .languagesResponseDtos(country.getLanguages()
                        .stream()
                        .map(languagesEntity -> LanguagesResponseDto.builder().language(languagesEntity.getLanguage()).build())
                        .collect(Collectors.toList()))
                .build();
    }

    private List<CountryStatsResponseDto> countryToStatsResponseDto(CountriesEntity country) {
        List<CountryStatsEntity> countryStats = countryStatsRepository.findByCountryId(country.getCountryId());
        return countryStats.stream().map(stats ->
            CountryStatsResponseDto.builder()
                    .name(country.getName())
                    .countryCode3(country.getCountryCode3())
                    .gdp(stats.getGdp())
                    .population(stats.getPopulation())
                    .year(stats.getYear())
                    .build()
            ).collect(Collectors.toList());
    }

    private List<ContinentInfoResponseDto> countryToContinentInfoResponseDto(CountriesEntity country) {
        List<CountryStatsEntity> countryStats = countryStatsRepository.findByCountryId(country.getCountryId());
        RegionsEntity regions = country.getRegionsByRegionId();
        String continentsEntityName = regions.getContinentsByContinentId().getName();

        return countryStats.stream().map(stats ->
                ContinentInfoResponseDto.builder()
                        .continentName(continentsEntityName)
                        .regionName(regions.getName())
                        .countryName(country.getName())
                        .gdp(stats.getGdp())
                        .population(stats.getPopulation())
                        .year(stats.getYear())
                        .build()
        ).collect(Collectors.toList());
    }
}
