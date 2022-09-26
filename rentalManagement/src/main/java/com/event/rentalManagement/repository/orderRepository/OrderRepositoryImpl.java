package com.event.rentalManagement.repository.orderRepository;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.event.rentalManagement.entity.Address;
import com.event.rentalManagement.entity.Customer;
import com.event.rentalManagement.entity.Order;
import com.event.rentalManagement.entity.OrdersResponse;
import com.event.rentalManagement.entity.User;
import com.event.rentalManagement.entity.enums.RequestStatus;
import com.event.rentalManagement.repository.addressRepository.AddressRepository;
import com.event.rentalManagement.repository.customerRepository.CustomerRepository;
import com.event.rentalManagement.repository.userRepository.UserRepository;

/*
 * public class OrderRepositoryImpl implements OrderRepositoryCustom {
 * 
 * }
 */
public class OrderRepositoryImpl implements OrderRepositoryCustom {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;
	
	Logger LOG = LoggerFactory.getLogger(OrderRepositoryImpl.class);

	@Override
	public Page<Order> findOrderByCustomerEmail(String email, Pageable page) {

		try {
			LOG.info("findOrderByCustomerEmail function called");
			Customer customerFetched = customerRepository.findByEmail(email);

			return orderRepository.findByCustomerId(customerFetched.getId(), page);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in findOrderByCustomerEmail");
			return null;
		}
	}

	@Override
	public List<Order> getCustomerOrdersByList(String username) {

		try {
			
			LOG.info("getCustomerOrdersByList function called");
			User userFetched = userRepository.findByUserNameAndUserStatus(username, true);

			Customer customerFetched = customerRepository.findByEmail(userFetched.getUserEmail());

			return orderRepository.findByCustomerId(customerFetched.getId());
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getCustomerOrdersByList");
			return null;
		}
	}

	/*
	@Override
	public List<OrdersResponse> getAllCustomerOrdersByList() {

		try {
			
			LOG.info("getAllCustomerOrdersByList function called");
			List<Order> allOrders = orderRepository.findAll();

			List<OrdersResponse> allOrderResponse = new ArrayList<OrdersResponse>();
			
			
			for(Order order : allOrders) {

				Address billingAddress = addressRepository.findById(order.getBillingAddress().getId()).orElse(null);
				Address shippingAddress = addressRepository.findById(order.getShippingAddress().getId()).orElse(null);
				Customer customer = customerRepository.findById(order.getCustomer().getId()).orElse(null);
				
				//making sure to clear the order items with only necessary items
				List<Order> customerOrdersList = new ArrayList<>(customer.getOrders());
				
				System.out.println("Size of customerOrdersList: "+customerOrdersList.size());
		
				for(int i = 0; i < customerOrdersList.size(); i++) {
					
					Set<Order> newCustomerOrders = new HashSet<>();
					System.out.println("The value of i: "+i+" current size: "+customerOrdersList.size());
					
					Order retrievedCOrder = customerOrdersList.get(i);
					
					for(Order ord : customerOrdersList) {
						if(retrievedCOrder.getOrderTrackingNumber().toString() == ord.getOrderTrackingNumber().toString()) {
							newCustomerOrders = new HashSet<>();
							newCustomerOrders.add(retrievedCOrder);
							
							customer.setOrders(newCustomerOrders);
							
							OrdersResponse ordersResponse = OrdersResponse.builder()
									.id(order.getId())
									.orderTrackingNumber(order.getOrderTrackingNumber())
									.totalPrice(order.getTotalPrice())
									.totalQuantity(order.getTotalQuantity())
									.billingAddress(billingAddress)
									.shippingAddress(shippingAddress)
									.customer(customer)
									.status(order.getStatus())
									.dateCreated(order.getDateCreated())
									.lastUpdated(order.getLastUpdated())
									.build();

							allOrderResponse.add(ordersResponse);			
							break;
						}
					}
					
					for(int j = 0; j < customerOrdersList.size(); j++) { 
						
						System.out.println("Comparing: "+retrievedCOrder.getOrderTrackingNumber().toString()+" with: "+customerOrdersList.get(j).getOrderTrackingNumber().toString()+"= "+(retrievedCOrder.getOrderTrackingNumber().toString() == customerOrdersList.get(j).getOrderTrackingNumber().toString()));
						if(retrievedCOrder.getOrderTrackingNumber().toString() == customerOrdersList.get(j).getOrderTrackingNumber().toString()) {
							newCustomerOrders = new HashSet<>();
							newCustomerOrders.add(retrievedCOrder);
							
							customer.setOrders(newCustomerOrders);
							
							OrdersResponse ordersResponse = OrdersResponse.builder()
									.id(order.getId())
									.orderTrackingNumber(order.getOrderTrackingNumber())
									.totalPrice(order.getTotalPrice())
									.totalQuantity(order.getTotalQuantity())
									.billingAddress(billingAddress)
									.shippingAddress(shippingAddress)
									.customer(customer)
									.status(order.getStatus())
									.dateCreated(order.getDateCreated())
									.lastUpdated(order.getLastUpdated())
									.build();

							allOrderResponse.add(ordersResponse);			
							break;
						}
					}
					
				}	
					
			}
				
				
				for(Order custOrder : customerOrdersList) {
					LOG.info("Checking for order : -----------------");
					LOG.info(custOrder.toString());
					
					for(Order cOrder : customerOrdersList) {
						
						LOG.info("Inner loop inside cOrder: ==============");
						LOG.info(cOrder.toString());
						System.out.println(order.getOrderTrackingNumber() == cOrder.getOrderTrackingNumber());
						LOG.info("==============");
						
						if(order.getOrderTrackingNumber().toString() == custOrder.getOrderTrackingNumber().toString())
							newCustomerOrders.add(custOrder);
					}
				}
				
				

			return allOrderResponse;
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getAllCustomerOrdersByList");
			return null;
		}
	}
	*/
	
	@Override
	public List<OrdersResponse> getAllCustomerOrdersByList() {
		
		try {
			List<Order> allOrders = orderRepository.findAll();

			List<OrdersResponse> allOrderResponse = new ArrayList<OrdersResponse>();
			
			//first: loop it in forLoop
			for(Order orderObject : allOrders) {
				
				//we are iterating through each order
				//sending orderTrackingNumber and customerObject in function
				
				Address billingAddress = addressRepository.findById(orderObject.getBillingAddress().getId()).orElse(null);
				Address shippingAddress = addressRepository.findById(orderObject.getShippingAddress().getId()).orElse(null);
				Customer orderCustomer = customerRepository.findById(orderObject.getCustomer().getId()).orElse(null);
				
				Customer modifiedCustomer = matchOrderWithCustomer(orderObject.getOrderTrackingNumber(), orderCustomer);
				
				//developing the orderResponse Object
				OrdersResponse ordersResponse = OrdersResponse.builder()
						.id(orderObject.getId())
						.orderTrackingNumber(orderObject.getOrderTrackingNumber())
						.totalPrice(orderObject.getTotalPrice())
						.totalQuantity(orderObject.getTotalQuantity())
						.billingAddress(billingAddress)
						.shippingAddress(shippingAddress)
						.customer(modifiedCustomer)
						.status(orderObject.getStatus())
						.dateCreated(orderObject.getDateCreated())
						.lastUpdated(orderObject.getLastUpdated())
						.build();

				allOrderResponse.add(ordersResponse);
			}
			
			return allOrderResponse;
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getAllCustomerOrdersbyList");
			LOG.error(ex.getLocalizedMessage());
			return null;
		}
		
	}
	
	//modification of customer
	public Customer matchOrderWithCustomer(String orderTrackingNumber, Customer customer) {
		
		try {
			Set<Order> allOrdersForCustomer = customer.getOrders();
			
			ArrayList<Order> allOrdersForCustomerList = new ArrayList<>(allOrdersForCustomer);
			
			
			ArrayList<Order> modifiedOrdersForCustomerList = new ArrayList<>();
			
			//second, loop through the ordersList in customerObject
			for(int i = 0; i < allOrdersForCustomer.size(); i++) {
				if(orderTrackingNumber == allOrdersForCustomerList.get(i).getOrderTrackingNumber())
					modifiedOrdersForCustomerList.add(allOrdersForCustomerList.get(i));
				
			}
			
			Set<Order> filteredOrdersForCustomer = new HashSet<>(modifiedOrdersForCustomerList);
			
			customer.setOrders(filteredOrdersForCustomer);
			
			
			return customer;
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in matchOrderwithCustomer");
			return null;
		}
	}

	@Override
	public Order updateStatusByOrderTrackingNumber(String orderTrackingNumber, RequestStatus requestStatus) {

		try {
			
			LOG.info("updateStatusByOrderTrackingNumber function called");
			Order orderFetched = orderRepository.findByOrderTrackingNumber(orderTrackingNumber);
			if(orderFetched == null)
				return null;

			orderFetched.setStatus(requestStatus.toString());

			return orderRepository.save(orderFetched);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in updateStatusByOrderTrackingNumber");
			return null;
		}
	}

	@Override
	public OrdersResponse getOrderInfoByOrderTrackingNumber(String orderTrackingNumber) {

		try {
			
			LOG.info("getOrderInfoByOrderTrackingNumber function called");
			Order order = orderRepository.findByOrderTrackingNumber(orderTrackingNumber);

			OrdersResponse orderResponse = null;

			Address billingAddress = addressRepository.findById(order.getBillingAddress().getId()).orElse(null);
			Address shippingAddress = addressRepository.findById(order.getShippingAddress().getId()).orElse(null);
			Customer customer = customerRepository.findById(order.getCustomer().getId()).orElse(null);

			OrdersResponse ordersResponse = OrdersResponse.builder()
					.id(order.getId())
					.orderTrackingNumber(order.getOrderTrackingNumber())
					.totalPrice(order.getTotalPrice())
					.totalQuantity(order.getTotalQuantity())
					.billingAddress(billingAddress)
					.shippingAddress(shippingAddress)
					.customer(customer)
					.status(order.getStatus())
					.dateCreated(order.getDateCreated())
					.lastUpdated(order.getLastUpdated())
					.build();


			return ordersResponse;
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getOrderInfoByOrderTrackingNumber");
			return null;
		}
	}

	//get ordersResponse by dateRange
	@Override
	public List<OrdersResponse> getOrderInfoListByDateRangeAndCustomerEmail(String customerEmail, String startDate,
			String endDate) {
		
		try {
			
			Customer customerFetched = customerRepository.findByEmail(customerEmail);
			if(customerFetched == null)
				return null;
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");      
			Date startingDate = formatter.parse(startDate);
			Date endingDate = formatter.parse(endDate);
			
			List<Order> matchedOrders = orderRepository.findByCustomerIdAndDateCreatedBetween(customerFetched.getId(), startingDate, endingDate);
			
			List<OrdersResponse> allOrderResponse = new ArrayList<OrdersResponse>();
			for(Order order : matchedOrders) {

				Address billingAddress = addressRepository.findById(order.getBillingAddress().getId()).orElse(null);
				Address shippingAddress = addressRepository.findById(order.getShippingAddress().getId()).orElse(null);

				OrdersResponse ordersResponse = OrdersResponse.builder()
						.id(order.getId())
						.orderTrackingNumber(order.getOrderTrackingNumber())
						.totalPrice(order.getTotalPrice())
						.totalQuantity(order.getTotalQuantity())
						.billingAddress(billingAddress)
						.shippingAddress(shippingAddress)
						.customer(customerFetched)
						.status(order.getStatus())
						.dateCreated(order.getDateCreated())
						.lastUpdated(order.getLastUpdated())
						.build();

				allOrderResponse.add(ordersResponse);
			}
			return allOrderResponse;
			
		} catch(Exception ex) {
			System.out.println("Exception caught in date range API");
			return null;
		}
	}

	@Override
	public List<OrdersResponse> getOrderByCustomerEmail(String customerEmail) {
		
		try {
			
			LOG.info("getOrderByCustomerEmail function called");
			Customer customerFetched = customerRepository.findByEmail(customerEmail);
			if(customerFetched == null)
				return null;
			
			List<Order> allOrdersFetched = orderRepository.findByCustomerId(customerFetched.getId());
			
			List<OrdersResponse> allOrderResponse = new ArrayList<OrdersResponse>();
			for(Order order : allOrdersFetched) {

				Address billingAddress = addressRepository.findById(order.getBillingAddress().getId()).orElse(null);
				Address shippingAddress = addressRepository.findById(order.getShippingAddress().getId()).orElse(null);

				OrdersResponse ordersResponse = OrdersResponse.builder()
						.id(order.getId())
						.orderTrackingNumber(order.getOrderTrackingNumber())
						.totalPrice(order.getTotalPrice())
						.totalQuantity(order.getTotalQuantity())
						.billingAddress(billingAddress)
						.shippingAddress(shippingAddress)
						.customer(customerFetched)
						.status(order.getStatus())
						.dateCreated(order.getDateCreated())
						.lastUpdated(order.getLastUpdated())
						.build();

				allOrderResponse.add(ordersResponse);
			}
			
			return allOrderResponse;
			
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getOrderByCustomerEmail");
			return null;
		}
	}

	@Override
	public List<OrdersResponse> getOrdersbyMonth(Integer monthValue, Integer yearValue) {
		
		try {
			
			LOG.info("getOrdersbyMonth function called");
			List<Order> allOrders = orderRepository.findAll();
			if(allOrders.isEmpty())
				return null;
			
			LocalDateTime finalLocalDateTime;
			List<OrdersResponse> allOrdersByMonth = new ArrayList<OrdersResponse>();
			for(Order order : allOrders) {
				//converting to localDateTime instead of timeStamp object
				finalLocalDateTime = order.getDateCreated().toInstant().atZone(ZoneId.of("Asia/Kolkata")).toLocalDateTime();
				
				if((finalLocalDateTime.getMonthValue() == monthValue) && (finalLocalDateTime.getYear() == yearValue)) {
					
					Address billingAddress = addressRepository.findById(order.getBillingAddress().getId()).orElse(null);
					Address shippingAddress = addressRepository.findById(order.getShippingAddress().getId()).orElse(null);
					Customer customerFetched = customerRepository.findById(order.getCustomer().getId()).orElse(null);
					
					OrdersResponse ordersResponse = OrdersResponse.builder()
							.id(order.getId())
							.orderTrackingNumber(order.getOrderTrackingNumber())
							.totalPrice(order.getTotalPrice())
							.totalQuantity(order.getTotalQuantity())
							.billingAddress(billingAddress)
							.shippingAddress(shippingAddress)
							.customer(customerFetched)
							.status(order.getStatus())
							.dateCreated(order.getDateCreated())
							.lastUpdated(order.getLastUpdated())
							.build();
					
					allOrdersByMonth.add(ordersResponse);
				}
			}
			return allOrdersByMonth;
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getOrdersbyMonth");
			return null;
		}
	}

	@Override
	public List<OrdersResponse> getOrdersFromToday() {
		
		try {
			
			LOG.info("getOrdersFromToday function called");
			List<Order> allOrders = orderRepository.findAll();
			if(allOrders.isEmpty())
				return null;
			
			LocalDateTime todayDateTime = LocalDateTime.now();
			Integer todayDate = todayDateTime.getDayOfMonth();
			Integer todayMonth = todayDateTime.getMonthValue();
			Integer todayYear = todayDateTime.getYear();
			
			LocalDateTime finalLocalDateTime;
			List<OrdersResponse> allOrdersByDay = new ArrayList<OrdersResponse>();
			
			for(Order order : allOrders) {
				//converting to localDateTime instead of timeStamp object
				finalLocalDateTime = order.getDateCreated().toInstant().atZone(ZoneId.of("Asia/Kolkata")).toLocalDateTime();
				
				if((finalLocalDateTime.getDayOfMonth() == todayDate) && (finalLocalDateTime.getMonthValue() == todayMonth) 
						&& (finalLocalDateTime.getYear() == todayYear)) {
					
					Address billingAddress = addressRepository.findById(order.getBillingAddress().getId()).orElse(null);
					Address shippingAddress = addressRepository.findById(order.getShippingAddress().getId()).orElse(null);
					Customer customerFetched = customerRepository.findById(order.getCustomer().getId()).orElse(null);
					
					OrdersResponse ordersResponse = OrdersResponse.builder()
							.id(order.getId())
							.orderTrackingNumber(order.getOrderTrackingNumber())
							.totalPrice(order.getTotalPrice())
							.totalQuantity(order.getTotalQuantity())
							.billingAddress(billingAddress)
							.shippingAddress(shippingAddress)
							.customer(customerFetched)
							.status(order.getStatus())
							.dateCreated(order.getDateCreated())
							.lastUpdated(order.getLastUpdated())
							.build();
					
					allOrdersByDay.add(ordersResponse);
				}
			}
			
			return allOrdersByDay;
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getOrdersFromToday");
			return null;
		}
	}

	@Override
	public List<OrdersResponse> getAllOrdersByStatus(String status) {
		
		try {
			
			LOG.info("getAllOrdersByStatus function called");
			List<Order> allOrders = orderRepository.findByStatus(status);
			if(allOrders == null)
				return null;
			
			List<OrdersResponse> allOrdersResponse = new ArrayList<OrdersResponse>();
			
			for(Order order : allOrders) {
					
				Address billingAddress = addressRepository.findById(order.getBillingAddress().getId()).orElse(null);
				Address shippingAddress = addressRepository.findById(order.getShippingAddress().getId()).orElse(null);
				Customer customerFetched = customerRepository.findById(order.getCustomer().getId()).orElse(null);
					
				OrdersResponse ordersResponse = OrdersResponse.builder()
						.id(order.getId())
						.orderTrackingNumber(order.getOrderTrackingNumber())
						.totalPrice(order.getTotalPrice())
						.totalQuantity(order.getTotalQuantity())
						.billingAddress(billingAddress)
						.shippingAddress(shippingAddress)
						.customer(customerFetched)
						.status(order.getStatus())
						.dateCreated(order.getDateCreated())
						.lastUpdated(order.getLastUpdated())
						.build();
					
				allOrdersResponse.add(ordersResponse);
			}
			
			return allOrdersResponse;
			
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getAllOrdersByStatus");
			return null;
		}
		
	}

	@Override
	public List<OrdersResponse> getAllOrdersByPriceRange(BigDecimal startPrice, BigDecimal endPrice) {
		
		try {
			
			LOG.info("getAllOrdersByPriceRange function called");
			List<Order> allOrders = orderRepository.findAll();
			if(allOrders == null)
				return null;
			
			List<OrdersResponse> allOrdersResponse = new ArrayList<OrdersResponse>();
			for(Order order : allOrders) {
				
				if((order.getTotalPrice().intValue() >= startPrice.intValue()) && (order.getTotalPrice().intValue() <= endPrice.intValue())) {
					
					Address billingAddress = addressRepository.findById(order.getBillingAddress().getId()).orElse(null);
					Address shippingAddress = addressRepository.findById(order.getShippingAddress().getId()).orElse(null);
					Customer customerFetched = customerRepository.findById(order.getCustomer().getId()).orElse(null);
						
					OrdersResponse ordersResponse = OrdersResponse.builder()
							.id(order.getId())
							.orderTrackingNumber(order.getOrderTrackingNumber())
							.totalPrice(order.getTotalPrice())
							.totalQuantity(order.getTotalQuantity())
							.billingAddress(billingAddress)
							.shippingAddress(shippingAddress)
							.customer(customerFetched)
							.status(order.getStatus())
							.dateCreated(order.getDateCreated())
							.lastUpdated(order.getLastUpdated())
							.build();
						
					allOrdersResponse.add(ordersResponse);
					
				}	
			}
			return allOrdersResponse;
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getAllOrdersByPriceRange");
			return null;
		}
		
	}

}