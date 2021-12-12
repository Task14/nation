package com.example.nation.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "region_areas")
public class RegionAreasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "region_name")
    private String regionName;
    @Basic
    @Column(name = "region_area")
    private BigDecimal regionArea;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegionAreasEntity that = (RegionAreasEntity) o;
        return Objects.equals(regionName, that.regionName) && Objects.equals(regionArea, that.regionArea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionName, regionArea);
    }
}
