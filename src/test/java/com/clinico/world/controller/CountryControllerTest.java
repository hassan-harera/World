package com.clinico.world.controller;


import com.clinico.world.dto.CountryInfo;
import com.clinico.world.entity.Country;
import com.clinico.world.repository.CountryRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootTest
public class CountryControllerTest {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${server.port}")
    private String port;

    @Autowired
    private CountryRepository countryRepository;

    @BeforeEach
    public void assert_application_is_running() {
        try {
            restTemplate.getForEntity("http://localhost:" + port, Object.class);
        } catch (HttpClientErrorException exception) {
            Assertions.assertThat(exception.getStatusCode().value()).isEqualTo(HttpStatus.NOT_FOUND.value());
        }
    }

    @BeforeEach
    public void assert_port_not_null() {
        Assertions.assertThat(port).isNotNull();
    }

    @BeforeEach
    public void assert_country_repository_not_null() {
        Assertions.assertThat(countryRepository).isNotNull();
    }

    @Test
    public void getting_country_info_for_a_valid_code_should_return_ok() {
        Page<Country> page = countryRepository.findAll(Pageable.ofSize(1).first());
        Assertions.assertThat(page.isEmpty()).isFalse();

        Country country = page.get().findFirst().get();

        ResponseEntity<CountryInfo> response = restTemplate.getForEntity("http://localhost:" + port + "/" + country.getCode(), CountryInfo.class);
        Assertions.assertThat(response.getStatusCode().value()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void getting_country_info_for_a_valid_code_should_return_bad_request() {
        try {
            restTemplate.getForEntity("http://localhost:" + port + "/123", CountryInfo.class);
        } catch (HttpClientErrorException exception) {
            Assertions.assertThat(exception.getStatusCode().value()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        }
    }
}
