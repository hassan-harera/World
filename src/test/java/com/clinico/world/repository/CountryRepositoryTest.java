package com.clinico.world.repository;

import com.clinico.world.entity.Country;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void getting_all_countries_should_not_be_null() {
        List<Country> countries = countryRepository.findAll();
        Assertions.assertThat(countries).isNotNull();
    }

    @Test
    public void countries_should_not_be_empty() {
        List<Country> countries = countryRepository.findAll();
        Assertions.assertThat(countries.isEmpty()).isFalse();
    }

    @Test
    public void getting_country_by_invalid_country_code_should_be_null() {
        Optional<Country> optionalCountry = countryRepository.findById("123");
        Assertions.assertThat(optionalCountry.isEmpty()).isTrue();
    }

    @Test
    public void getting_country_by_valid_country_code_should_not_be_null() {
        Page<Country> page = countryRepository.findAll(Pageable.ofSize(1).first());
        Assertions.assertThat(page.isEmpty()).isFalse();

        Country country = page.get().findFirst().get();
        Assertions.assertThat(countryRepository.findById(country.getCode()).isPresent()).isTrue();
    }

    @Test
    public void getting_country_languages_by_mapping_existing_country_should_not_be_null() {
        Page<Country> page = countryRepository.findAll(Pageable.ofSize(1).first());
        Assertions.assertThat(page.isEmpty()).isFalse();

        Country country = page.get().findFirst().get();
        Assertions.assertThat(country.getCountryLanguages()).isNotNull();
        Assertions.assertThat(country.getCountryLanguages().isEmpty()).isFalse();
    }
}
