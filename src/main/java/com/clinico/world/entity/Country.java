package com.clinico.world.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
@NoArgsConstructor
@Setter
@Getter
public class Country {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "population")
    private String population;

    @Column(name = "continent")
    private String continent;

    @Column(name = "life_expectancy")
    private String lifeExpectancy;

    @OneToMany(mappedBy = "countryCode", fetch = FetchType.EAGER)
    private List<CountryLanguage> countryLanguages;
}
