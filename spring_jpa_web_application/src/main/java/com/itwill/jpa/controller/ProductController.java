package com.itwill.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.entity.Product;
import com.itwill.jpa.service.ProductService;

public class ProductController {

	public ResponseEntity<List<Product>> getProductList() {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	public ResponseEntity<Product> getProduct() {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	public ResponseEntity<Product> createProduct() {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	public ResponseEntity<Product> changeProductName() throws Exception {

		return ResponseEntity.status(HttpStatus.OK).body(null);

	}

	public ResponseEntity<String> deleteProduct() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
