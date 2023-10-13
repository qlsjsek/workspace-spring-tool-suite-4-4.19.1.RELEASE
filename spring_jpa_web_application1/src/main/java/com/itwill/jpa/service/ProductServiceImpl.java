package com.itwill.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.entity.Product;
import com.itwill.jpa.repository.ProductRepository;
@Service

public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public List<Product> products() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(Long no) {

		return productRepository.findById(no).get();
	}

	@Override
	public Product saveProduct(Product product) {

		return productRepository.save(product);
	}
	
	@Override
	public Product updateProduct(Product product) throws Exception {
		Product findProduct=productRepository.findById(product.getProductId()).get();
		findProduct.setName(product.getName());
		findProduct.setPrice(product.getPrice());
		findProduct.setStock(product.getStock());
		//productRepository.save(findProduct);
		return findProduct;
	}

	@Override
	public void deleteProduct(Long no) throws Exception {
		productRepository.deleteById(no);
	}

}
