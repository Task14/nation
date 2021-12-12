package com.example.nation.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "guests")
public class GuestsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "guest_id")
    private Integer guestId;
    @Basic
    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuestsEntity that = (GuestsEntity) o;
        return Objects.equals(guestId, that.guestId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestId, name);
    }
}
