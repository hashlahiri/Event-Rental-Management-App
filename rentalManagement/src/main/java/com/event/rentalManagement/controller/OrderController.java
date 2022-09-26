package com.event.rentalManagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.event.rentalManagement.entity.Order;
import com.event.rentalManagement.entity.OrdersResponse;
import com.event.rentalManagement.entity.enums.RequestStatus;
import com.event.rentalManagement.service.OrderService;

import io.swagger.annotations.ApiOperation;

@RestController
//@Api(value = "Order Controller", description = "Order API Controller")
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@ApiOperation(value = "Get all customer related orders by page", notes = "API to get all orders by email paged")
	@RequestMapping(value = "/search/findOrderByCustomerEmail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Order>> findOrderByCustomerEmailController(
			@RequestParam(value = "email", required = true) String email, Pageable page) {

		Page<Order> response = orderService.findOrderByCustomerEmailService(email, page);
		
		if(response == null)
			return new ResponseEntity<Page<Order>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Page<Order>>(response, HttpStatus.OK);

	}

	@ApiOperation(value = "Get all customer related orders by list", notes = "API to get all orders by email list")
	@RequestMapping(value = "/getCustomerOrders/list/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Order>> getCustomerOrdersByListController(
			@RequestParam(value = "username", required = true) String username) {

		List<Order> response = orderService.getCustomerOrdersByListService(username);
		
		if(response == null)
			return new ResponseEntity<List<Order>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Order>>(response, HttpStatus.OK);

	}

	@ApiOperation(value = "Get all orders by list", notes = "API to get all orders by list")
	@RequestMapping(value = "/getAllOrders/list/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdersResponse>> getCustomerOrdersByListController() {

		List<OrdersResponse> response = orderService.getAllCustomerOrdersByListService();
		
		if(response == null)
			return new ResponseEntity<List<OrdersResponse>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<OrdersResponse>>(response, HttpStatus.OK);
	}

	// CSV downloader for report generation, for ADMIN ALL ORDERS SECTION
	@ApiOperation(value = "Download all orders by list CSV download", notes = "API to get CSV file downloaded for all orders")
	@RequestMapping(value = "/getAllOrdersCSVDownload/list/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void getAllOrdersCsvDownloadController(HttpServletResponse response) {

		orderService.getAllCustomerOrdersCsvDownloadService(response);
	}

	// CSV downloader for report generation, for CUSTOMER ALL ORDERS SECTION
	@ApiOperation(value = "Download all user orders by list CSV download", notes = "API to get CSV file downloaded for all orders")
	@RequestMapping(value = "/getAllUserOrdersCSVDownload/list/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void getAllUserOrdersCsvDownloadController(HttpServletResponse response, 
			@RequestParam(value = "username", required = true) String username) {

		orderService.getAllUserOrdersCsvDownloadService(response, username);
	}
	
	@ApiOperation(value = "Modify Order Status by orderTrackingNumber", notes = "API to modify Order Status by orderTrackingNumber")
	@RequestMapping(value = "/updateStatusByOrderTrackingNumber/", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> updateStatusByOrderTrackingNumberController(
			@RequestParam(value = "orderTrackingNumber", required = true) String orderTrackingNumber,
			@RequestParam(value = "requestStatus", required = true) RequestStatus requestStatus) {
		
		Order response = orderService.updateStatusByOrderTrackingNumberService(orderTrackingNumber, requestStatus);
		
		if(response == null)
			return new ResponseEntity<Order>(response, HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Order>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get orderInfo by orderTrackingNumber", notes = "API to get orderInfo by orderTrackingNumber")
	@RequestMapping(value = "/getOrderInfoByOrderTrackingNumber/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdersResponse> getOrderInfoByOrderTrackingNumberController(
			@RequestParam(value = "orderTrackingNumber", required = true) String orderTrackingNumber) {
		
		OrdersResponse response = orderService.getOrderInfoByOrderTrackingNumberService(orderTrackingNumber);
		
		if(response == null)
			return new ResponseEntity<OrdersResponse>(response, HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<OrdersResponse>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get orderInfo list by orderDateRange and customerEmail", notes = "API to get orderInfo list by orderDateRange and customerEmail")
	@RequestMapping(value = "/getOrderByDateRangeAndEmail/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdersResponse>> getOrderInfoListByDateRangeAndCustomerEmailController(
			@RequestParam(value = "customerEmail", required = true) String customerEmail,
			@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate) {
		
		List<OrdersResponse> response = orderService.getOrderInfoListByDateRangeAndCustomerEmailService(customerEmail, startDate, endDate);
		
		if(response == null)
			return new ResponseEntity<List<OrdersResponse>>(response, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<OrdersResponse>>(response, HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Get all customer related orders by customerEmail", notes = "API to get all orders by email")
	@RequestMapping(value = "/getCustomerOrdersByCustomerEmail/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdersResponse>> getOrderByCustomerEmailController(
			@RequestParam(value = "customerEmail", required = true) String customerEmail) {

		List<OrdersResponse> response = orderService.getOrderByCustomerEmailService(customerEmail);
		
		if(response == null)
			return new ResponseEntity<List<OrdersResponse>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<OrdersResponse>>(response, HttpStatus.OK);

	}
	
	@ApiOperation(value = "Get all orders by month", notes = "API to get all orders by month")
	@RequestMapping(value = "/getOrdersByMonthAndYear/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdersResponse>> getOrdersByMonthController(
			@RequestParam(value = "month", required = true) Integer monthValue,
			@RequestParam(value = "year", required = true) Integer yearValue) {
		
		List<OrdersResponse> response = orderService.getOrdersbyMonthService(monthValue, yearValue);
		
		if(response == null)
			return new ResponseEntity<List<OrdersResponse>>(response, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<OrdersResponse>>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get all orders from today", notes = "API to get all orders from today")
	@RequestMapping(value = "/getOrdersFromToday/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdersResponse>> getOrdersFromTodayController() {
		
		List<OrdersResponse> response = orderService.getOrdersFromTodayService();
		
		if(response == null)
			return new ResponseEntity<List<OrdersResponse>>(response, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<OrdersResponse>>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get all orders according to status", notes = "API to get all orders according to status")
	@RequestMapping(value = "/getAllOrdersByStatus/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdersResponse>> getAllOrdersByStatusController(
			@RequestParam(value = "status", required = true) String status) {
		
		List<OrdersResponse> response = orderService.getAllOrdersByStatusService(status);
		
		if(response == null)
			return new ResponseEntity<List<OrdersResponse>>(response, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<OrdersResponse>>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get all orders between range of price", notes = "API to get all orders in between range of price")
	@RequestMapping(value = "/getAllOrdersByPriceRange/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdersResponse>> getAllOrdersByPriceRangeController(
			@RequestParam(value = "startPrice", required = true) String startPrice,
			@RequestParam(value = "endPrice", required = true) String endPrice) {
		
		List<OrdersResponse> response = orderService.getAllOrdersByPriceRangeService(startPrice, endPrice);
		
		if(response == null)
			return new ResponseEntity<List<OrdersResponse>>(response, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<OrdersResponse>>(response, HttpStatus.OK);
		
	}

}
