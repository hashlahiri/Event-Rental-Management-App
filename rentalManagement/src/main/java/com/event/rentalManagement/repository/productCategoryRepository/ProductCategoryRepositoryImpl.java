package com.event.rentalManagement.repository.productCategoryRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.event.rentalManagement.entity.ProductCategory;

public class ProductCategoryRepositoryImpl implements ProductCategoryRepositoryCustom {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	Logger LOG = LoggerFactory.getLogger(ProductCategoryRepositoryImpl.class);

	@Override
	public List<ProductCategory> findAllProductCategory() {
		
		try {
			LOG.info("findAllProductCategory function called");
			LOG.info("Find all newsletter api was hit to retrieve all product category as list");
			return productCategoryRepository.findAll();
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in findAllProductCategory");
			return null;
		}
	}

	@Override
	public ProductCategory insertProductCategory(ProductCategory productCategory) {
		
		try {
			LOG.info("insertProductCategory function called");
			LOG.info("Insert product category api was hit to save product category object into db");
			return productCategoryRepository.save(productCategory); 
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in insertProductCategory");
			return null;
		}
		
	}

}
