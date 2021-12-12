package com.example.nation.handler;

import com.example.nation.models.dto.response.ContinentsInfoResponseDto;
import com.example.nation.models.dto.response.CountriesResponseDto;
import com.example.nation.models.dto.response.CountriesStatsResponseDto;
import com.example.nation.models.dto.response.CountryDetailsResponseDto;
import com.example.nation.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NationHandler {

    @Autowired
    private NationService nationService;


    public CountriesResponseDto getCountries() {
        return nationService.getCountries();
    }

    public CountryDetailsResponseDto getCountryDetails(Integer id) {
        return nationService.getCountry(id);
    }

    public CountriesStatsResponseDto getCountriesStats() {
        return nationService.getCountriesStats();
    }

    public ContinentsInfoResponseDto getContinentsInfo() {
        return nationService.getContinentsInfo();
    }
}
