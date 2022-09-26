package com.event.rentalManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.event.rentalManagement.entity.State;
import com.event.rentalManagement.service.StateService;

@RestController
//@Api(value = "State Controller", description = "State API Controller")
@RequestMapping("/api/states")
public class StateController {

	@Autowired
	private StateService stateService;

	//@ApiOperation(value = "Get all states with country code", notes = "API to retrieve list of states belonging to specific country", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/search/findByCountryCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<State>> findAllStatesByCountryCodeController(
			@RequestParam(value = "code", required = true) String code) {

		List<State> response = stateService.findAllStatesByCountryCodeService(code);
		
		if(response == null)
			return new ResponseEntity<List<State>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<State>>(response, HttpStatus.OK);
	}

}
