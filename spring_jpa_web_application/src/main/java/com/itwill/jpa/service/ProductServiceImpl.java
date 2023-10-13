package com.itwill.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.entity.Product;
import com.itwill.jpa.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> products() {

		return null;
	}

	@Override
	public Product getProduct(Long number) {

		return null;
	}

	@Override
	public Product saveProduct(Product product) {

		return null;
	}

	@Override
	public Product updateProduct(Product product) throws Exception {

		return null;
	}

	@Override
	public void deleteProduct(Long number) throws Exception {

	}

}
