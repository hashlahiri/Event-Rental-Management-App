package com.event.rentalManagement.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class PurchaseResponse {

	@NonNull
	private final String orderTrackingNumber;
}
