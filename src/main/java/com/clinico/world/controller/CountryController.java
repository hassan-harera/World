package com.clinico.world.controller;

import com.clinico.world.dto.CountryInfo;
import com.clinico.world.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/{code}")
    public ResponseEntity<CountryInfo> getCountryInfo(@PathVariable(name = "code") String code) {
        CountryInfo countryInfo = countryService.getCountryInfo(code);
        if (null == countryInfo) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(countryInfo);
    }
}
