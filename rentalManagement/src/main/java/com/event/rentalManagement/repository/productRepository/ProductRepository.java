package com.event.rentalManagement.repository.productRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.event.rentalManagement.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

	@Query(value = "SELECT * FROM Product WHERE product_category_id = :id", nativeQuery = true)
	public Page<Product> findByProductCategoryId(@Param("id") Long id, Pageable page);

	public Page<Product> findByNameContaining(String name, Pageable page);

	/*
	 * @Query(value =
	 * "SELECT * FROM Orders WHERE Amount BETWEEN :startAmt AND :endAmt" ,
	 * nativeQuery=true) List<OrderEntity> findOrdersBy(@Param("startAmt") int
	 * startAmt, @Param("endAmt") int endAmt);
	 */
}
