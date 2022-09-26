package com.event.rentalManagement.repository.orderRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.rentalManagement.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryCustom {
	
	public Page<Order> findByCustomerId(Long customerId, Pageable page);
	
	public List<Order> findByCustomerId(Long customerId);
	
	public Order findByOrderTrackingNumber(String orderTrackingNumber);
	
	public List<Order> findByCustomerIdAndDateCreatedBetween(Long customerId, Date startDate, Date endDate);
	
	public List<Order> findByStatus(String status);
	
	
}