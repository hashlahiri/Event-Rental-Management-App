package com.event.rentalManagement.repository.orderRepository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.event.rentalManagement.entity.Order;
import com.event.rentalManagement.entity.OrdersResponse;
import com.event.rentalManagement.entity.enums.RequestStatus;

/*
 * public interface OrderRepositoryCustom {
 * 
 * }
 */
public interface OrderRepositoryCustom {

	public Page<Order> findOrderByCustomerEmail(String email, Pageable page);
	
	public List<Order> getCustomerOrdersByList(String username);
	
	public List<OrdersResponse> getAllCustomerOrdersByList();
	
	public Order updateStatusByOrderTrackingNumber(String orderTrackingNumber, RequestStatus requestStatus);
	
	public OrdersResponse getOrderInfoByOrderTrackingNumber(String orderTrackingNumber);
	
	public List<OrdersResponse> getOrderInfoListByDateRangeAndCustomerEmail(String customerEmail, String startDate, String endDate);
	
	public List<OrdersResponse> getOrderByCustomerEmail(String customerEmail);
	
	public List<OrdersResponse> getOrdersbyMonth(Integer monthValue, Integer yearValue);

	public List<OrdersResponse> getOrdersFromToday();
	
	public List<OrdersResponse> getAllOrdersByStatus(String status);
	
	public List<OrdersResponse> getAllOrdersByPriceRange(BigDecimal startPrice, BigDecimal endPrice);
	
}