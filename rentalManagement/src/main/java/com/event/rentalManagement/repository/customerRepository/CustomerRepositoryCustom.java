package com.event.rentalManagement.repository.customerRepository;

import com.event.rentalManagement.entity.Purchase;
import com.event.rentalManagement.entity.PurchaseResponse;

/*
 * public interface CustomerRepositoryCustom {
 * 
 * }
 */

public interface CustomerRepositoryCustom {
	
	public PurchaseResponse placeOrder(Purchase purchase);
	
}