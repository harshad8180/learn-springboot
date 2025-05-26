package com.example.product.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.product.dto.CategoryDTO;
import com.example.product.entity.Category;
import com.example.product.exception.CategoryAlreadyExistsException;
import com.example.product.repository.CategoryRepository;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

	@Mock
	private CategoryRepository categoryRepository;

	@InjectMocks
	private CategoryService categoryService;

	private Category category;
	private CategoryDTO categoryDTO;

	@BeforeEach
	void setUp() throws Exception {
		category = new Category();
		category.setId(1L);
		category.setName("test");

		categoryDTO = new CategoryDTO();
		categoryDTO.setId(1L);
		categoryDTO.setName("test");
	}

	
	@Test
	void testCreateCategory_categoryShouldCreated() {
		when(categoryRepository.findByName(categoryDTO.getName())).thenReturn(Optional.empty());
		when(categoryRepository.save(any(Category.class))).thenReturn(category);

		CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
		assertNotNull(savedCategory);
		assertEquals(categoryDTO.getName(), savedCategory.getName());
	}

	@Test
	void createCategory_ShouldThrowException_WhenCategoryAlreadyExists() {
		when(categoryRepository.findByName(categoryDTO.getName())).thenReturn(Optional.of(category));
		assertThrows(CategoryAlreadyExistsException.class, () -> categoryService.createCategory(categoryDTO));
		verify(categoryRepository, times(0)).save(any(Category.class));
	}

	

}
