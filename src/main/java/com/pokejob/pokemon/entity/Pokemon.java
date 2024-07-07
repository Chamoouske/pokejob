package com.pokejob.pokemon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Pokemon {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column(name = "_order")
    private Long order;
    @Column
    private Long baseExperience;
    @Column
    private Double height;
    @Column
    private Double weight;

    @Override
    public String toString() {
        return "Pokemon [id=" + id + ", name=" + name + ", order=" + order + ", baseExperience=" + baseExperience + ", height=" + height + ", weight=" + weight + "]";
    }
}
