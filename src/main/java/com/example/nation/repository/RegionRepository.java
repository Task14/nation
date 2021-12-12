package com.example.nation.repository;

import com.example.nation.models.entities.RegionsEntity;
import org.springframework.data.repository.CrudRepository;

public interface RegionRepository extends CrudRepository<RegionsEntity, Integer> {
    RegionsEntity findByName(String name);
}