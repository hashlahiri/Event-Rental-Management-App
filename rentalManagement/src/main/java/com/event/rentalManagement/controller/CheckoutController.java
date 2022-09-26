package com.event.rentalManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.event.rentalManagement.entity.Purchase;
import com.event.rentalManagement.entity.PurchaseResponse;
import com.event.rentalManagement.service.CheckoutService;

@RestController
//@Api(value = "Checkout Controller", description = "Checkout API Controller")
@RequestMapping("/api/checkout")
public class CheckoutController {

	@Autowired
	private CheckoutService checkoutService;

	//@ApiOperation(value = "Place Order and checkout", notes = "API for placing an order for the bucket and checkout customer", response = PurchaseResponse.class)
	@RequestMapping(value = "/purchase", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PurchaseResponse> placeOrder(@RequestBody(required = true) Purchase purchase) {

		PurchaseResponse response = checkoutService.placeOrderService(purchase);

		return new ResponseEntity<PurchaseResponse>(response, HttpStatus.OK);
	}

}
