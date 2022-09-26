package com.event.rentalManagement.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.rentalManagement.entity.Purchase;
import com.event.rentalManagement.entity.PurchaseResponse;
import com.event.rentalManagement.repository.customerRepository.CustomerRepository;

@Service
@Transactional
public class CheckoutService {

	@Autowired
	private CustomerRepository customerRepository;

	public PurchaseResponse placeOrderService(Purchase purchase) {

		return customerRepository.placeOrder(purchase);
	}

}