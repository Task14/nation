package com.example.nation.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public class CountryStatsEntityPK implements Serializable {
    @Column(name = "country_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryId;
    @Column(name = "year")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryStatsEntityPK that = (CountryStatsEntityPK) o;
        return Objects.equals(countryId, that.countryId) && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, year);
    }
}
