package com.example.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.dto.ProductDTO;
import com.example.product.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Product REST API CRUD operation", description = "CREATE, READ, UPDATE and DELETE operations for Product REST API")

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

	private ProductService productService;

	// get all Products
	@Operation(summary = "Fetch all products", description = "REST API to fetch all products.")
	@GetMapping
	public List<ProductDTO> getAllProducts() {
		return productService.getAllProducts();

	}

	// createProduct
	@Operation(summary = "Create product", description = "REST API to create product.")

	@ApiResponse(responseCode = "201", description = "CREATED")
	
	@PreAuthorize("hasAuthority('ROLE_SELLER')")

	@PostMapping
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
		return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
	}

	// get product by id
	@Operation(summary = "Fetch product by product ID", description = "REST API to Fetch product by product ID.")

	@GetMapping("/{id}")
	public ProductDTO getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	// updateProduct
	@Operation(summary = "Update product by product ID", description = "REST API to Update product by product ID.")
	
	@PreAuthorize("hasAuthority('ROLE_SELLER')")
	
	@PutMapping("/{id}")
	public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
		return productService.updateProduct(id, productDTO);
	}

	// delete product
	@Operation(summary = "Delete product by product ID", description = "REST API to Delete product by product ID.")
	
	@PreAuthorize("hasAuthority('ROLE_SELLER')")
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		return productService.deleteProduct(id);
	}
}
