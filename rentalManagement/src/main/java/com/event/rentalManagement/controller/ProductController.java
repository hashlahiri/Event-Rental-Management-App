package com.event.rentalManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.event.rentalManagement.entity.Product;
import com.event.rentalManagement.service.ProductService;

@RestController
//@Api(value = "Product Controller", description = "Product API Controller")
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PreAuthorize("hasRole('User')")
	//@ApiOperation(value = "Search for a product by Category Id", notes = "Search for a single product by its category Id API Controller", response = Product.class)
	@RequestMapping(value = "/search/findByCategoryId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Product>> findAllProductsByCategoryIdController(
			@RequestParam(value = "id", required = true) String id, Pageable page) {

		Page<Product> response = productService.findAllProductsByCategoryIdService(id, page);
		
		if(response == null)
			return new ResponseEntity<Page<Product>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Page<Product>>(response, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('User')")
	//@ApiOperation(value = "Search by product name", notes = "Search for a product by its name", response = Product.class)
	@RequestMapping(value = "/search/findByNameContaining", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Product>> findAllBySearchingByNameController(
			@RequestParam(value = "name", required = true) String name, Pageable page) {

		Page<Product> response = productService.findAllBySearchingByNameService(name, page);
		
		if(response == null)
			return new ResponseEntity<Page<Product>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Page<Product>>(response, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('User')")
	//@ApiOperation(value = "Get particular product information", notes = "Get particular product information api", response = Product.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> findProductByProductIdController(
			@PathVariable(value = "id", required = true) String id) {

		Product response = productService.findProductByProductIdService(id);
		
		if(response == null)
			return new ResponseEntity<Product>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Product>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> insertProductController(
			@RequestBody(required = true) Product product){
		
		Product response = productService.insertProductService(product);
		
		if(response == null)
			return new ResponseEntity<Product>(response, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Product>(response, HttpStatus.OK);
		
	}
}
