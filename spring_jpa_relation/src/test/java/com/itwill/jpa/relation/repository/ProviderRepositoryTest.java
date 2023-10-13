package com.itwill.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import javax.transaction.Transactional;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.Provider;

class ProviderRepositoryTest extends SpringJpaRelationApplicationTests {
	@Autowired
	ProviderRepository providerRepository;
	
	@Test
	void providerWithProductsSaveAndRead() {
		
		Provider provider = Provider.builder()
										.name("네임")
										.build();
		
		Product product1 = Product.builder()
									.name("오라클")
									.price(545454)
									.stock(133)
									.build();
		Product product2 = Product.builder()
									.name("머신러닝")
									.price(45000)
									.stock(50)
									.build();
		Product product3 = Product.builder()
									.name("인공지능")
									.price(30000)
									.stock(30)
									.build();
		/*
		 * 연관설정 Product -> Provider (n:1)
		 */
		product1.setProvider(provider);
		product2.setProvider(provider);
		product3.setProvider(provider);
		
		provider.getProducts().add(product1);
		provider.getProducts().add(product2);
		provider.getProducts().add(product3);
		
		providerRepository.save(provider);
		System.out.println("------------read-----------");
		Provider findProvider = providerRepository.findById(1L).get();
		List<Product> productList = findProvider.getProducts();
		for (Product product : productList) {
			System.out.println(product);
		}
	}
}
