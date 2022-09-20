package com.clinico.world.repository;

import com.clinico.world.entity.Country;
import com.clinico.world.entity.CountryLanguage;
import com.clinico.world.entity.pk.CountryLanguagePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguagePk> {


    @Query("select cl from CountryLanguage cl where cl.countryCode = ?1")
    List<CountryLanguage> getCountryLanguages(String code);
}
