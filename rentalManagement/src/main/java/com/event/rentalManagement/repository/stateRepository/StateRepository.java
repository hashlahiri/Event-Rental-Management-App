package com.event.rentalManagement.repository.stateRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.rentalManagement.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>, StateRepositoryCustom {

	public List<State> findByCountryId(Integer countryId);

}