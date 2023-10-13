package com.itwill.jpa.dao;

import java.util.List;

import com.itwill.jpa.dto.ProductResponseDto;
import com.itwill.jpa.entity.Product;


public interface ProductDao {

    Product insertProduct(Product product);

    Product selectProduct(Long no);

    Product updateProduct(Product product) throws Exception;

    void deleteProduct(Long no) throws Exception;

	List<Product> selectList();

}
