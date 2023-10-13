package com.itwill.jpa.relation.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.ProductDetail;

class ProductDetailRepositoryTest extends SpringJpaRelationApplicationTests{
	@Autowired
	ProductDetailRepository productDetailRepository;
	@Test
	@Disabled
	void productDetailWithProductSaveRead() {
		Product product = Product.builder()
									.name("JPA")
									.price(20000)
									.stock(50)
									.build();
		
		ProductDetail productDetail=ProductDetail.builder()
													.description("아주좋은책")
													.build();
		/*
		 * 연관관계설정
		 * ProductDetail-->Product
		 */
		productDetail.setProduct(product);
		productDetailRepository.save(productDetail);
		
		System.out.println("-------read--------");
		System.out.println(">>ProductDetail"+productDetailRepository.findById(1L));
		System.out.println(">>ProductDetail-->Product"+productDetailRepository.findById(1L).get().getProduct());
	}
}
