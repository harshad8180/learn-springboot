package com.example.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product.dto.ProductDTO;
import com.example.product.entity.Category;
import com.example.product.entity.Product;
import com.example.product.exception.CategoryNotFoundException;
import com.example.product.mapper.ProductMapper;
import com.example.product.repository.CategoryRepository;
import com.example.product.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;

	// create product
	public ProductDTO createProduct(ProductDTO productDTO) {
		// name, description, price, categoryId

		Category category = categoryRepository.findById(productDTO.getCategoryId())
				.orElseThrow(() -> new CategoryNotFoundException("Category id "+productDTO.getCategoryId()+" Not Found"));

		// DTO -> entity
		Product product = ProductMapper.toProductEntity(productDTO, category);
		product = productRepository.save(product);

		// entity -> DTO
		return ProductMapper.toProductDTO(product);
	}

	// get all products
	public List<ProductDTO> getAllProducts() {
		return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
	}

	// get product by id
	public ProductDTO getProductById(Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		return ProductMapper.toProductDTO(product);
	}
	
	// update product
	public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
		 Product product = productRepository.findById(id)
				 .orElseThrow(() -> new RuntimeException("Product not found"));

		 Category category = categoryRepository.findById(productDTO.getCategoryId())
					.orElseThrow(() -> new RuntimeException("Category Not Found"));
		 
		 product.setName(productDTO.getName());
		 product.setDescription(productDTO.getDescription());
		 product.setPrice(productDTO.getPrice());
		 product.setCategory(category);
		 
		 productRepository.save(product);
		 return ProductMapper.toProductDTO(product);
	}

	// delete product
	public String deleteProduct(Long id) {
		productRepository.deleteById(id);
		return "Product "+id+" has been deleted!";
	}
}
