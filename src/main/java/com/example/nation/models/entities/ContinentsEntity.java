package com.example.nation.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "continents")
public class ContinentsEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "continent_id")
    private Integer continentId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "continentsByContinentId")
    private Collection<RegionsEntity> regionsByContinentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContinentsEntity that = (ContinentsEntity) o;
        return Objects.equals(continentId, that.continentId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(continentId, name);
    }

}
