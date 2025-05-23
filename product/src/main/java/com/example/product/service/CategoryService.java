package com.example.product.service;

import java.util.List;
import java.util.Optional;

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
	
	// get all categories
	public List<CategoryDTO> getAllCategories(){
		return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
	}
	

	// create category
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		
		Optional<Category> optionalCategory = categoryRepository.findByName(categoryDTO.getName());
		if(optionalCategory.isPresent()) {
			throw new RuntimeException("Category already exists");
		}
		
		Category category = CategoryMapper.toCategoryEntity(categoryDTO);
		category = categoryRepository.save(category);
		return CategoryMapper.toCategoryDTO(category);
	}


	// get category by id
	public CategoryDTO getCategoryById(Long id) {
		Category category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
		return CategoryMapper.toCategoryDTO(category);
		
	}


	// delete category
	public String deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		return "Category "+id+" has been deleted!";
		
	}
	
	
	
}
