package com.event.rentalManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.event.rentalManagement.entity.Product;
import com.event.rentalManagement.repository.productRepository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Page<Product> findAllProductsByCategoryIdService(String id, Pageable page) {

		return productRepository.findAllProductsByCategoryId(id, page);
	}

	public Page<Product> findAllBySearchingByNameService(String name, Pageable page) {

		return productRepository.findAllBySearchingByName(name, page);
	}

	public Product findProductByProductIdService(String id) {

		return productRepository.findProductByProductId(id);
	}
	
	public Product insertProductService(Product product) {
		
		return productRepository.insertProduct(product);
	}

}
