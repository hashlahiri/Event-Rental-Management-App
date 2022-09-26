package com.event.rentalManagement.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_category")
// @Data -- known bug
@Getter
@Setter
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productCategoryId;

	private String categoryName;

	@JsonManagedReference
	@OneToMany(mappedBy = "productCategoryId", targetEntity = Product.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Product> product = new HashSet<Product>();

	/*
	 * @JsonBackReference
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "category") private
	 * Set<Product> products;
	 * 
	 * 
	 * @OneToMany(mappedBy = "category") private List<Product> products = new
	 * ArrayList<Product>();;
	 */
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "id") private ProductCategory productCategory;
	 */
}
