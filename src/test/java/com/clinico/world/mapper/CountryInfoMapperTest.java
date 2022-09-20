package com.clinico.world.mapper;


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
public class CountryInfoMapperTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void mapping_a_non_nullable_country_should_not_be_null() {
        Page<Country> page = countryRepository.findAll(Pageable.ofSize(1).first());
        Assertions.assertThat(page.isEmpty()).isFalse();

        Country country = page.get().findFirst().get();
        CountryInfo countryInfo = CountryInfoMapper.map(country);
        Assertions.assertThat(countryInfo).isNotNull();
    }
}
