package com.itwill.jpa.service;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.entity.Product;
@Transactional
public interface ProductService {
	Product getProduct(Long number);
	Product saveProduct(Product product);
	Product updateProduct(Product product) throws Exception;
	void deleteProduct(Long number) throws Exception;
	List<Product> products();
}