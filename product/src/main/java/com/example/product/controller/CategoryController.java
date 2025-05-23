package com.example.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.dto.CategoryDTO;
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
	public ResponseEntity<CategoryDTO>  createCategory(@RequestBody CategoryDTO categoryDTO) {
		return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
	}
	
	
}
