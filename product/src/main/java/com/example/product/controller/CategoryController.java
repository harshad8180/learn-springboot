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
import com.example.product.exception.CategoryAlreadyExistsException;
import com.example.product.service.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
	private CategoryService categoryService;
	
	// get all Category
	@GetMapping
	public  List<CategoryDTO> getAllCategories(){
		return categoryService.getAllCategories();
		
	}
	
	// create Categories
	@PostMapping
	public ResponseEntity<?>  createCategory(@RequestBody CategoryDTO categoryDTO) {
		
		try {
			CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
		}catch (CategoryAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
		
//		return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
	}
	
	
	// get category by id
	@GetMapping("/{id}")
	public CategoryDTO getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}
	
	// delete category
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable Long id) {
		return categoryService.deleteCategory(id);
	}
	
}
