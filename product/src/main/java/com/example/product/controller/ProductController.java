package com.example.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.dto.ProductDTO;
import com.example.product.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
	
	private ProductService productService;
	
	// getProduct
	// createProduct
	@PostMapping
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
		return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
	}
	// updateProduct
	// get product by id
	// delete product
}
