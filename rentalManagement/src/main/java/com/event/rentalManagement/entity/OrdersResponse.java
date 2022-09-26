package com.event.rentalManagement.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrdersResponse {

	private Long id;

	private String orderTrackingNumber;

	private BigDecimal totalPrice;

	private int totalQuantity;

	private Address billingAddress;

	private Customer customer;

	private Address shippingAddress;

	private String status;

	private Date dateCreated;

	private Date lastUpdated;

}
