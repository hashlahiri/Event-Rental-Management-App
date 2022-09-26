package com.event.rentalManagement.repository.countryRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.event.rentalManagement.entity.Country;

/*
public class CountryRepositoryImpl implements CountryRepositoryCustom {

}
*/
public class CountryRepositoryImpl implements CountryRepositoryCustom {

	@Autowired
	private CountryRepository countryRepository;

	Logger LOG = LoggerFactory.getLogger(CountryRepositoryImpl.class);
	
	@Override
	public List<Country> findAllCountries() {
		
		try {
			LOG.info("findAllCountries function called");
			return countryRepository.findAll();
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in findAllCountries");
			return null;
		}
	}

}