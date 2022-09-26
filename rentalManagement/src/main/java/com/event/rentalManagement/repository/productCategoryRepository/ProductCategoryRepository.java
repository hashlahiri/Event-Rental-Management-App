package com.event.rentalManagement.repository.productCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.rentalManagement.entity.ProductCategory;

public interface ProductCategoryRepository
		extends JpaRepository<ProductCategory, Long>, ProductCategoryRepositoryCustom {

}