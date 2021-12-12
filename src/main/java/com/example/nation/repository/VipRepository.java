package com.example.nation.repository;

import com.example.nation.models.entities.VipsEntity;
import org.springframework.data.repository.CrudRepository;

public interface VipRepository extends CrudRepository<VipsEntity, Integer> {
    VipsEntity findByName(String name);
}