package com.clinico.world.entity;

import com.clinico.world.entity.pk.CountryLanguagePk;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "country_language")
@IdClass(CountryLanguagePk.class)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CountryLanguage {

    @Id
    @Column(name = "country_code")
    private String countryCode;

    @Id
    @Column(name = "language")
    private String language;

    @Column(name = "percentage")
    private Double percentage;
}
