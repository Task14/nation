package com.example.nation.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "languages")
public class LanguagesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "language_id")
    private Integer languageId;
    @Basic
    @Column(name = "language")
    private String language;

    @ManyToMany(mappedBy = "languages", fetch = FetchType.LAZY)
    private Set<CountriesEntity> students = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguagesEntity that = (LanguagesEntity) o;
        return Objects.equals(languageId, that.languageId) && Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageId, language);
    }

}
