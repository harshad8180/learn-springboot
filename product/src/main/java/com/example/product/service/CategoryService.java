package com.example.product.service;

import org.springframework.stereotype.Service;

import com.example.product.dto.CategoryDTO;
import com.example.product.entity.Category;
import com.example.product.mapper.CategoryMapper;
import com.example.product.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {
	private CategoryRepository categoryRepository;
	
	// create category
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		Category category = CategoryMapper.toCategoryEntity(categoryDTO);
		category = categoryRepository.save(category);
		return CategoryMapper.toCategoryDTO(category);
	}
	
	// get all categories
	
	// get category by id
	
	// delete category
}
