package com.example.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.dto.CategoryDTO;
import com.example.product.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Category REST API CRUD operation", description = "CREATE, READ, UPDATE and DELETE operations for Category REST API")

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
	private CategoryService categoryService;

	// get all Category
	@Operation(summary = "Fetch all categories", description = "REST API to fetch all categories along with products.")
	@GetMapping
	public List<CategoryDTO> getAllCategories() {
		return categoryService.getAllCategories();

	}

	// create Categories
	@Operation(summary = "Create category", description = "REST API to create category.")

	@ApiResponse(responseCode = "201", description = "CREATED")

	@PostMapping
	public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {

		CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
	}

	// get category by id
	@Operation(summary = "Fetch category by category ID", description = "REST API to Fetch category by category ID.")
	@GetMapping("/{id}")
	public CategoryDTO getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}

	// delete category
	@Operation(summary = "Delete category by category ID", description = "REST API to Delete category by category ID.")
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable Long id) {
		return categoryService.deleteCategory(id);
	}

}
