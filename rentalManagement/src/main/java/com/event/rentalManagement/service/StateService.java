package com.event.rentalManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.rentalManagement.entity.State;
import com.event.rentalManagement.repository.stateRepository.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;

	public List<State> findAllStatesByCountryCodeService(String code) {

		return stateRepository.findAllStatesByCountryCode(code);
	}
}
