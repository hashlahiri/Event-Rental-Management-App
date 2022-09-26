package com.event.rentalManagement.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Table(name = "product")
@Data

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "category_id", nullable = false) private ProductCategory
	 * category;
	 */
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "category_id") private ProductCategory category;
	 */
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="productCategoryId") private ProductCategory
	 * productCategory;
	 */

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "product_category_id")
	private ProductCategory productCategoryId;

	@Column(name = "sku")
	private String sku;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "unit_price")
	private BigDecimal unitPrice;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "active")
	private boolean active;

	@Column(name = "units_in_stock")
	private int unitsInStock;

	@Column(name = "date_created")
	@CreationTimestamp
	private Date dateCreated;

	@Column(name = "last_updated")
	@UpdateTimestamp
	private Date lastUpdated;

}
