package com.event.rentalManagement.repository.customerRepository;
/*
 * public class CustomerRespositoryImpl implements CustomerRepositoryCustom {
 * 
 * }
 */

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.event.rentalManagement.entity.Customer;
import com.event.rentalManagement.entity.Order;
import com.event.rentalManagement.entity.OrderItem;
import com.event.rentalManagement.entity.Purchase;
import com.event.rentalManagement.entity.PurchaseResponse;
import com.event.rentalManagement.entity.enums.RequestStatus;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public PurchaseResponse placeOrder(Purchase purchase) {

		// retrieve the order info
		Order order = purchase.getOrder();
		order.setStatus(RequestStatus.PENDING.toString());
		
		// generate tracking number
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);

		// populate order with orderItems
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));

		// populate order with billingAddress and shippingAddress
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());

		// populate customer with order
		Customer customer = purchase.getCustomer();

		// check if this is an existing customer from DB
		String theEmail = customer.getEmail();

		Customer customerFromDB = customerRepository.findByEmail(theEmail);

		// if pre existing customer
		if (customerFromDB != null) {
			customer = customerFromDB;
		}

		customer.add(order);

		// save to the database
		customerRepository.save(customer);

		// return a response
		return new PurchaseResponse(orderTrackingNumber);

	}

	private String generateOrderTrackingNumber() {

		// we want to create a unique id thats random and hard to guess
		// generating a UUID for cryptic nature

		return UUID.randomUUID().toString();
	}

}