package com.example.nation.controller;

import com.example.nation.handler.NationHandler;
import com.example.nation.models.dto.response.ContinentsInfoResponseDto;
import com.example.nation.models.dto.response.CountriesResponseDto;
import com.example.nation.models.dto.response.CountriesStatsResponseDto;
import com.example.nation.models.dto.response.CountryDetailsResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NationController {

    @Autowired
    private NationHandler nationHandler;

    @GetMapping(value = "/countries")
    public CountriesResponseDto getAllCountries() {
        return nationHandler.getCountries();
    }


    @GetMapping(value = "/countries/{id}")
    public CountryDetailsResponseDto getCountry(@PathVariable String id) {
        return nationHandler.getCountryDetails(Integer.valueOf(id));
    }

    @GetMapping(value = "/countries_stats")
    public CountriesStatsResponseDto getCountriesStats() {
        return nationHandler.getCountriesStats();
    }

    @GetMapping(value = "/continents_info")
    public ContinentsInfoResponseDto getContinentsInfo() {
        return nationHandler.getContinentsInfo();
    }
}
