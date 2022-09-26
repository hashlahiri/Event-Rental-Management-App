package com.event.rentalManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.event.rentalManagement.entity.ProductCategory;
import com.event.rentalManagement.service.ProductCategoryService;

@RestController
//@Api(value = "Product Category Controller", description = "Product Category API Controller")
@RequestMapping("/api/")
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService productCategoryService;

	/*
	 * Product Category being exposed
	 */
	// @ApiOperation(value = "Product category being exposed", notes = "Product
	// Category equivalent of RestResourceRepository", response =
	// ProductCategory.class)
	@RequestMapping(value = "product-category", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductCategory>> findAllProductCategoryController() {

		List<ProductCategory> response = productCategoryService.findAllProductCategoryService();
		
		if(response == null)
			return new ResponseEntity<List<ProductCategory>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<ProductCategory>>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "addProductCategory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductCategory> insertProductCategoryController(
			@RequestBody(required = true) ProductCategory productCategory) {

		ProductCategory response = productCategoryService.insertProductCategoryService(productCategory);
		
		if(response == null)
			return new ResponseEntity<ProductCategory>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<ProductCategory>(response, HttpStatus.OK);
	}

}
