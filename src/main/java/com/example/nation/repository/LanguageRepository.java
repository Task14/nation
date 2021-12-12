package com.example.nation.repository;

import com.example.nation.models.entities.LanguagesEntity;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<LanguagesEntity, Integer> {
    LanguagesEntity findByLanguage(String language);
}