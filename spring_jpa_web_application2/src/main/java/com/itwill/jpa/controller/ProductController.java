package com.itwill.jpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.itwill.jpa.dto.ProductDto;
import com.itwill.jpa.dto.ProductResponseDto;
import com.itwill.jpa.dto.ProductUpdateDto;
import com.itwill.jpa.service.ProductService;
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
    @GetMapping()
    public ResponseEntity<List<ProductResponseDto>> getProductList(){
    		return ResponseEntity
    					.status(HttpStatus.OK)
    					.body(productService.products());
    }
    
    @GetMapping("/{no}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable(value = "no") Long no) {
       return ResponseEntity
    		   		.status(HttpStatus.OK)
    		   		.body(productService.getProduct(no));
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {
       return ResponseEntity
    		   	.status(HttpStatus.OK)
    		   	.body(productService.saveProduct(productDto));
    }

    @PutMapping
    public ResponseEntity<ProductResponseDto> upadteProduct(
    			@RequestBody ProductUpdateDto productUpdateDto) throws Exception {
    	return ResponseEntity
        		.status(HttpStatus.OK)
        		.body(productService.updateProduct(productUpdateDto));

    }

    @DeleteMapping("/{no}")
    public ResponseEntity<Map> deleteProduct(@PathVariable(name = "no") Long no) throws Exception {
    	productService.deleteProduct(no);
        return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());
    }

}