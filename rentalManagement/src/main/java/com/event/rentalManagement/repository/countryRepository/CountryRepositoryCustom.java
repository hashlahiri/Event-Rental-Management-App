package com.event.rentalManagement.repository.countryRepository;
/*
public interface CountryRepositoryCustom {

}
*/

import java.util.List;

import com.event.rentalManagement.entity.Country;

public interface CountryRepositoryCustom {

	public List<Country> findAllCountries();

}