package com.example.nation.repository;

import com.example.nation.models.entities.GuestsEntity;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<GuestsEntity, Integer> {
    GuestsEntity findByName(String name);
}