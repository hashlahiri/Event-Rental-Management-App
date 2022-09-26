package com.event.rentalManagement.repository.productRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.event.rentalManagement.entity.Product;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

	@Autowired
	private ProductRepository productRepository;
	
	Logger LOG = LoggerFactory.getLogger(ProductRepositoryImpl.class);

	@Override
	public Page<Product> findAllProductsByCategoryId(String id, Pageable page) {
		
		try {
			
			LOG.info("findAllProductsByCategoryId function called");
			LOG.info("Function called to retrieve all products by category Id");
			
			return productRepository.findByProductCategoryId(Long.parseLong(id), page);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in findAllProductsByCategoryId");
			return null;
		}

	}

	@Override
	public Page<Product> findAllBySearchingByName(String name, Pageable page) {

		try {
			
			LOG.info("findAllBySearchingByName function called");
			LOG.info("Function called to retrieve all search results by name");
			
			return productRepository.findByNameContaining(name, page);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in findAllBySearchingByName");
			return null;
		}
		
	}

	@Override
	public Product findProductByProductId(String id) {

		try {
			
			LOG.info("findProductByProductId function called");
			LOG.info("Function called to find product by product id");
			
			return productRepository.findById(Long.parseLong(id)).orElse(null);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in findProductByProductId");
			return null;
		}
		
	}

	@Override
	public Product insertProduct(Product product) {
		
		try {
			
			LOG.info("insertProduct function called");
			LOG.info("Function called to save product information in DB");
			
			return productRepository.save(product);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in insertProduct");
			return null;
		}
		
	}

}
