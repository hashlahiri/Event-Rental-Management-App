package com.event.rentalManagement.repository.addressRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.rentalManagement.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>, AddressRepositoryCustom {
	
	//merge with order
	public Address findById(String id);

}
