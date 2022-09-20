package com.clinico.world.service;


import com.clinico.world.dto.CountryInfo;
import com.clinico.world.entity.Country;
import com.clinico.world.mapper.CountryInfoMapper;
import com.clinico.world.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryService {

    @Autowired
    private final CountryRepository countryRepository;

    public CountryInfo getCountryInfo(String countryCode) {
        Optional<Country> country = countryRepository.findById(countryCode);
        return country.map(CountryInfoMapper::map).orElse(null);
    }
}
