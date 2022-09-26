package com.event.rentalManagement.repository.stateRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.event.rentalManagement.entity.Country;
import com.event.rentalManagement.entity.State;
import com.event.rentalManagement.repository.countryRepository.CountryRepository;

/*
public class StateRepositoryImpl implements StateRepositoryCustom {

}
*/
public class StateRepositoryImpl implements StateRepositoryCustom {

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CountryRepository countryRepository;
	
	Logger LOG = LoggerFactory.getLogger(StateRepositoryImpl.class);

	public List<State> findAllStatesByCountryCode(String code) {

		try {
			Country countryFetched = countryRepository.findByCode(code);

			if (countryFetched == null) {
				
				LOG.info("Could not fetch country by countryCode");
				LOG.info("No States loaded at the moment due to missing country");
				return null;
			}

			return stateRepository.findByCountryId(countryFetched.getId());
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in findAllStatesByCountryCode");;
			return null;
		}
		
	}
}