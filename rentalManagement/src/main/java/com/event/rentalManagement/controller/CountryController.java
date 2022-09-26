package com.event.rentalManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.event.rentalManagement.entity.Country;
import com.event.rentalManagement.service.CountryService;

@RestController
//@Api(value = "Country Controller", description = "Country API Controller")
@RequestMapping("/api/countries")
public class CountryController {

	@Autowired
	private CountryService countryService;

	//@ApiOperation(value = "Get all countries", notes = "API to get all countries")
	@RequestMapping(value = "/getAllCountries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Country>> findAllCountriesController() {

		List<Country> response = countryService.findAllCountriesService();
		
		if(response == null)
			return new ResponseEntity<List<Country>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Country>>(response, HttpStatus.OK);
	}
}
