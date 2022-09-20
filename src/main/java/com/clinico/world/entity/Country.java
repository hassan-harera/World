package com.clinico.world.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "country")
@NoArgsConstructor
@Setter
@Getter
public class Country {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "population")
    private String population;

    @Column(name = "continent")
    private String continent;

    @Column(name = "life_expectancy")
    private String lifeExpectancy;
}
