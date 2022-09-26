package com.event.rentalManagement.repository.countryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.rentalManagement.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>, CountryRepositoryCustom {

	public Country findByCode(String code);

}