package com.event.rentalManagement.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.event.rentalManagement.entity.Order;
import com.event.rentalManagement.entity.OrdersResponse;
import com.event.rentalManagement.entity.enums.RequestStatus;
import com.event.rentalManagement.repository.orderRepository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Page<Order> findOrderByCustomerEmailService(String email, Pageable page) {

		return orderRepository.findOrderByCustomerEmail(email, page);
	}
	
	public List<Order> getCustomerOrdersByListService(String username) {
		
		return orderRepository.getCustomerOrdersByList(username);
	}

	public List<OrdersResponse> getAllCustomerOrdersByListService() {
		
		return orderRepository.getAllCustomerOrdersByList();
	}
	
	//Orders CSV Download, ADMIN ALL ORDERS SECTION
	public void getAllCustomerOrdersCsvDownloadService(HttpServletResponse response) {
		
		try {
			//CSV download section
			response.setContentType("text/csv");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=orders_" + currentDateTime + ".csv";
	        response.setHeader(headerKey, headerValue);
	         
	        List<OrdersResponse> listOrders = orderRepository.getAllCustomerOrdersByList();
	 
	        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
	        String[] csvHeader = {"Id", "OrderTrackingNumber", "TotalPrice", "TotalQuantity", "BillingAddress", "Customer", "ShippingAddress", "Status", "DateCreated", "LastUpdated"};
	        String[] nameMapping = {"id", "orderTrackingNumber", "totalPrice", "totalQuantity", "billingAddress", "customer", "shippingAddress", "status", "dateCreated", "lastUpdated"};
	         
	        csvWriter.writeHeader(csvHeader);
	         
	        for (OrdersResponse order : listOrders) {
	            csvWriter.write(order, nameMapping);
	        }
	         
	        csvWriter.close();
	        
		} catch(Exception ex) {
			System.out.println("Exception caught while downloading all orders CSV");
		}
	
	}
	
	//Orders CSV Download, USER ALL ORDERS SECTION
	public void getAllUserOrdersCsvDownloadService(HttpServletResponse response, String username) {
		
		try {
			//CSV download section
			response.setContentType("text/csv");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=orders_" + currentDateTime + ".csv";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Order> allCustomerOrders = orderRepository.getCustomerOrdersByList(username);
	 
	        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
	        String[] csvHeader = {"Id", "OrderTrackingNumber", "TotalPrice", "TotalQuantity", "BillingAddress", "Customer", "ShippingAddress", "Status", "DateCreated", "LastUpdated"};
	        String[] nameMapping = {"id", "orderTrackingNumber", "totalPrice", "totalQuantity", "billingAddress", "customer", "shippingAddress", "status", "dateCreated", "lastUpdated"};
	         
	        csvWriter.writeHeader(csvHeader);
	         
	        for (Order order : allCustomerOrders) {
	            csvWriter.write(order, nameMapping);
	        }
	        csvWriter.close();
			
		} catch(Exception ex) {
			
			System.out.println("Exception caught while downloading all customer orders CSV");
		}
		
	}
	
	//modify status by orderTrackingNumber 
	public Order updateStatusByOrderTrackingNumberService(String orderTrackingNumber, RequestStatus requestStatus) {
		
		return orderRepository.updateStatusByOrderTrackingNumber(orderTrackingNumber, requestStatus);
	}
	
	public OrdersResponse getOrderInfoByOrderTrackingNumberService(String orderTrackingNumber) {
		
		return orderRepository.getOrderInfoByOrderTrackingNumber(orderTrackingNumber);
	}
	
	public List<OrdersResponse> getOrderInfoListByDateRangeAndCustomerEmailService(String customerEmail, String startDate, String endDate) {
		
		return orderRepository.getOrderInfoListByDateRangeAndCustomerEmail(customerEmail, startDate, endDate);
	}
	
	public List<OrdersResponse> getOrderByCustomerEmailService(String customerEmail) {
		
		return orderRepository.getOrderByCustomerEmail(customerEmail);
	}
	
	public List<OrdersResponse> getOrdersbyMonthService(Integer monthValue, Integer yearValue) {
		
		return orderRepository.getOrdersbyMonth(monthValue, yearValue);
	}
	
	public List<OrdersResponse> getOrdersFromTodayService() {
		
		return orderRepository.getOrdersFromToday();
	}
	
	public List<OrdersResponse> getAllOrdersByStatusService(String status) {
		
		return orderRepository.getAllOrdersByStatus(status);
	}
	
	public List<OrdersResponse> getAllOrdersByPriceRangeService(String startPrice, String endPrice) {
		
		return orderRepository.getAllOrdersByPriceRange(new BigDecimal(startPrice), new BigDecimal(endPrice));
	}
}
