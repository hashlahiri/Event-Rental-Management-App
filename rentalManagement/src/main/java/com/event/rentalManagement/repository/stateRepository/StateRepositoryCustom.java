package com.event.rentalManagement.repository.stateRepository;

import java.util.List;

import com.event.rentalManagement.entity.State;

/*
public interface StateRepositoryCustom {

}
*/
public interface StateRepositoryCustom {

	public List<State> findAllStatesByCountryCode(String code);
}