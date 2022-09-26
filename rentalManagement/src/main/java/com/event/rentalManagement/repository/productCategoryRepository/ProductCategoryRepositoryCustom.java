package com.event.rentalManagement.repository.productCategoryRepository;

import java.util.List;

import com.event.rentalManagement.entity.ProductCategory;

public interface ProductCategoryRepositoryCustom {

	public List<ProductCategory> findAllProductCategory();
	
	public ProductCategory insertProductCategory(ProductCategory productCategory);

}
