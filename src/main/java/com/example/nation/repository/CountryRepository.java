package com.example.nation.repository;

import com.example.nation.models.entities.CountriesEntity;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<CountriesEntity, Integer> {

    CountriesEntity findByName(String name);

}