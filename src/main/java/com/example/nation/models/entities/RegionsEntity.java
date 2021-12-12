package com.example.nation.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "regions")
public class RegionsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "region_id")
    private Integer regionId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "continent_id")
    private Integer continentId;
    @OneToMany(mappedBy = "regionsByRegionId")
    private Collection<CountriesEntity> countriesByRegionId;
    @ManyToOne
    @JoinColumn(name = "continent_id", referencedColumnName = "continent_id", nullable = false, insertable = false, updatable = false)
    private ContinentsEntity continentsByContinentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegionsEntity that = (RegionsEntity) o;
        return Objects.equals(regionId, that.regionId) && Objects.equals(name, that.name) && Objects.equals(continentId, that.continentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionId, name, continentId);
    }
}
