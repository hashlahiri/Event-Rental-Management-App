package com.event.rentalManagement.repository.productRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.event.rentalManagement.entity.Product;

public interface ProductRepositoryCustom {

	public Page<Product> findAllProductsByCategoryId(String id, Pageable page);

	public Page<Product> findAllBySearchingByName(String name, Pageable page);

	public Product findProductByProductId(String id);

	public Product insertProduct(Product product);
}
