package com.example.nation.repository;

import com.example.nation.models.entities.ContinentsEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContinentRepository extends CrudRepository<ContinentsEntity, Integer> {
    ContinentsEntity findByName(String name);
}