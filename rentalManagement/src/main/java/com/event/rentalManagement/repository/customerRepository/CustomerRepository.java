package com.event.rentalManagement.repository.customerRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.rentalManagement.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {
	
	public Customer findByEmail(String email);
	
	
	//merged with order
	public Customer findById(String id);
	
}