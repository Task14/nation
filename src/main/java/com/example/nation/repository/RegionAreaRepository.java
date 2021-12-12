package com.example.nation.repository;

import com.example.nation.models.entities.RegionAreasEntity;
import org.springframework.data.repository.CrudRepository;

public interface RegionAreaRepository extends CrudRepository<RegionAreasEntity, Integer> {
    RegionAreasEntity findByRegionName(String name);
}