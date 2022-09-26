package com.event.rentalManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.rentalManagement.entity.ProductCategory;
import com.event.rentalManagement.repository.productCategoryRepository.ProductCategoryRepository;

@Service
public class ProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	public List<ProductCategory> findAllProductCategoryService() {

		return productCategoryRepository.findAllProductCategory();
	}
	
	public ProductCategory insertProductCategoryService(ProductCategory productCategory) {
		
		return productCategoryRepository.insertProductCategory(productCategory);
	}
}
