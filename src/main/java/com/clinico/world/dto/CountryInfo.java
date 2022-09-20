package com.clinico.world.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CountryInfo {

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("continent")
    private String population;

    @NotNull
    @JsonProperty("continent")
    private String continent;

    @NotNull
    @JsonProperty("life_expectancy")
    private String lifeExpectancy;

    @NotNull
    @JsonProperty("country_language")
    private String countryLanguage;
}
