package com.itwill.jpa.service;


import java.util.List;

import com.itwill.jpa.dto.ProductDto;
import com.itwill.jpa.dto.ProductResponseDto;
import com.itwill.jpa.dto.ProductUpdateDto;

public interface ProductService {

    ProductResponseDto getProduct(Long no);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto updateProduct(ProductUpdateDto product) throws Exception;

    void deleteProduct(Long no) throws Exception;

	List<ProductResponseDto> products();

}