package com.event.rentalManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.rentalManagement.entity.Country;
import com.event.rentalManagement.repository.countryRepository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public List<Country> findAllCountriesService() {

		return countryRepository.findAllCountries();
	}

}
