package com.clinico.world.service;


import com.clinico.world.dto.CountryInfo;
import com.clinico.world.entity.Country;
import com.clinico.world.repository.CountryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@SpringBootTest
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void getting_country_info_with_valid_country_code_should_not_be_null() {
        Page<Country> page = countryRepository.findAll(Pageable.ofSize(1).first());
        Assertions.assertThat(page.isEmpty()).isFalse();

        Country country = page.get().findFirst().get();
        CountryInfo countryInfo = countryService.getCountryInfo(country.getCode());
        Assertions.assertThat(countryInfo).isNotNull();
    }

    @Test
    public void getting_country_info_with_invalid_country_code_should_not_be_null() {
        CountryInfo countryInfo = countryService.getCountryInfo("123");
        Assertions.assertThat(countryInfo).isNull();
    }
}
