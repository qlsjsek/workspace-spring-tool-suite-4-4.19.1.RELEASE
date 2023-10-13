package com.itwill.jpa.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.ProductDao;
import com.itwill.jpa.dto.ProductDto;
import com.itwill.jpa.dto.ProductResponseDto;
import com.itwill.jpa.dto.ProductUpdateDto;
import com.itwill.jpa.entity.Product;
import com.itwill.jpa.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;

	@Override
	public List<ProductResponseDto> products() {
		List<Product> productList = productDao.selectList();
		List<ProductResponseDto> productDtoList = new ArrayList<ProductResponseDto>();
		for (Product product : productList) {
			productDtoList.add(ProductResponseDto.toDto(product));
		}
		return productDtoList;
	}

	@Override
	public ProductResponseDto getProduct(Long productId) {
		Product product = productDao.selectProduct(productId);
		ProductResponseDto productResponseDto = ProductResponseDto.toDto(product);
		return productResponseDto;
	}

	@Override
	public ProductResponseDto saveProduct(ProductDto productDto) {
		Product product = productDao.insertProduct(Product.toEntity(productDto));
		ProductResponseDto productResponseDto =  ProductResponseDto.toDto(product);
		return productResponseDto;
	}

	@Override
	public ProductResponseDto updateProduct(ProductUpdateDto productUpdateDto) throws Exception {
		Product product = Product.builder().productId(productUpdateDto.getProductId()).name(productUpdateDto.getName()).build();
		Product updateProduct = productDao.updateProduct(product);
		ProductResponseDto productResponseDto = ProductResponseDto.toDto(updateProduct);
		return productResponseDto;
	}

	@Override
	public void deleteProduct(Long productId) throws Exception {
		productDao.deleteProduct(productId);
	}

}
