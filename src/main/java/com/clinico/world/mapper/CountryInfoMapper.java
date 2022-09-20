package com.clinico.world.mapper;

import com.clinico.world.dto.CountryInfo;
import com.clinico.world.entity.Country;
import com.clinico.world.entity.CountryLanguage;

import java.util.Comparator;

public class CountryInfoMapper {

    public static CountryInfo map(Country country) {
        return new CountryInfo(country.getName(), country.getPopulation(), country.getContinent(), country.getLifeExpectancy(), country.getCountryLanguages().stream().max(Comparator.comparingDouble(CountryLanguage::getPercentage)).get().getLanguage());
    }
}
