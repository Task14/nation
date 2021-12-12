package com.example.nation.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "country_stats", schema = "nation", catalog = "")
@IdClass(CountryStatsEntityPK.class)
public class CountryStatsEntity {

    @Id
    @Column(name = "country_id")
    private Integer countryId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "year")
    private Integer year;
    @Column(name = "population")
    private Double population;
    @Column(name = "gdp")
    private Double gdp;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false, insertable = false, updatable = false)
    private CountriesEntity countriesByCountryId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryStatsEntity that = (CountryStatsEntity) o;
        return Objects.equals(countryId, that.countryId) && Objects.equals(year, that.year) && Objects.equals(population, that.population) && Objects.equals(gdp, that.gdp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, year, population, gdp);
    }

}
