package com.clinico.world.repository;

import com.clinico.world.entity.CountryLanguage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
public class CountryLanguageRepositoryTest {

    @Autowired
    private CountryLanguageRepository countryLanguageRepository;

    @Test
    public void getting_all_countries_should_not_be_null() {
        List<CountryLanguage> countries = countryLanguageRepository.findAll();
        Assertions.assertThat(countries).isNotNull();
    }

    @Test
    public void countries_should_not_be_empty() {
        List<CountryLanguage> countries = countryLanguageRepository.findAll();
        Assertions.assertThat(countries.isEmpty()).isFalse();
    }

    @Test
    public void getting_country_languages_by_invalid_country_code_should_be_empty() {
        List<CountryLanguage> optLanguages = countryLanguageRepository.getCountryLanguages("123");
        Assertions.assertThat(optLanguages.isEmpty()).isTrue();
    }

    @Test
    public void getting_country_languages_by_valid_country_code_should_not_be_empty() {
        Page<CountryLanguage> page = countryLanguageRepository.findAll(Pageable.ofSize(1).first());
        Assertions.assertThat(page.isEmpty()).isFalse();

        CountryLanguage countryLanguage = page.get().findFirst().get();
        Assertions.assertThat(countryLanguageRepository.getCountryLanguages(countryLanguage.getCountryCode()).isEmpty()).isFalse();
    }

    @Test
    public void test_percentage_field() {
        Page<CountryLanguage> page = countryLanguageRepository.findAll(Pageable.ofSize(1).first());
        Assertions.assertThat(page.isEmpty()).isFalse();

        CountryLanguage countryLanguage = page.get().findFirst().get();
        Assertions.assertThat(countryLanguage.getPercentage()).isNotNull();
    }
}
