package com.example.nation.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "countries")
public class CountriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "name")
    private String name;

    @Column(name = "area")
    private BigDecimal area;

    @Column(name = "national_day")
    private Date nationalDay;

    @Column(name = "country_code2")
    private String countryCode2;

    @Column(name = "country_code3")
    private String countryCode3;

    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "region_id", nullable = false)
    private RegionsEntity regionsByRegionId;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "country_languages",
            joinColumns = {
                    @JoinColumn(name = "country_id", referencedColumnName = "country_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "language_id", referencedColumnName = "language_id",
                            nullable = false, updatable = false)})
    private Set<LanguagesEntity> languages = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountriesEntity that = (CountriesEntity) o;
        return Objects.equals(countryId, that.countryId) && Objects.equals(name, that.name) && Objects.equals(area, that.area) && Objects.equals(nationalDay, that.nationalDay) && Objects.equals(countryCode2, that.countryCode2) && Objects.equals(countryCode3, that.countryCode3) && Objects.equals(regionsByRegionId, that.regionsByRegionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, name, area, nationalDay, countryCode2, countryCode3, regionsByRegionId);
    }
}
