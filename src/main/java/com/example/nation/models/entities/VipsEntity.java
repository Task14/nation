package com.example.nation.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "vips")
public class VipsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "vip_id")
    private Integer vipId;
    @Basic
    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VipsEntity that = (VipsEntity) o;
        return Objects.equals(vipId, that.vipId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vipId, name);
    }
}
