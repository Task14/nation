package com.example.nation.repository;

import com.example.nation.models.entities.CountryStatsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryStatsRepository extends CrudRepository<CountryStatsEntity, Integer> {
    List<CountryStatsEntity> findByCountryId(Integer countryId);
}