package com.example.product.service;

import org.springframework.stereotype.Service;

import com.example.product.dto.ProductDTO;
import com.example.product.entity.Category;
import com.example.product.entity.Product;
import com.example.product.mapper.ProductMapper;
import com.example.product.repository.CategoryRepository;
import com.example.product.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	
	public ProductDTO createProduct(ProductDTO productDTO) {
		// name, description, price, categoryId
		
		Category category = categoryRepository.findById(productDTO.getCategoryId())
							.orElseThrow(()->new RuntimeException("Category Not Found"));
		
		// DTO -> entity
		Product product = ProductMapper.toProductEntity(productDTO, category);
		product = productRepository.save(product);
		
		// entity -> DTO
		return ProductMapper.toProductDTO(product);
	}
}
