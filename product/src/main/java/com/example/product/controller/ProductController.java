package com.example.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// get all Products
	@GetMapping
	public  List<ProductDTO> getAllProducts(){
		return productService.getAllProducts();
		
	}
	
	// createProduct
	@PostMapping
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
		return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
	}
	// get product by id
		@GetMapping("/{id}")
		public ProductDTO getProductById(@PathVariable Long id) {
			return productService .getProductById(id);
		}
	
	// updateProduct
	// delete product
}
