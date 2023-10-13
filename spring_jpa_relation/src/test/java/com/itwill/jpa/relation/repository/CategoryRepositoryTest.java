package com.itwill.jpa.relation.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Category;
import com.itwill.jpa.relation.entity.Product;

class CategoryRepositoryTest extends SpringJpaRelationApplicationTests{
	@Autowired
	CategoryRepository categoryRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	void categoryWithProductsSaveAndReadDelete() {
		/***************[CascadeType.PERSIST]**************/
		Category category=Category.builder().code("IT").name("오피스").build();
		Category category2=Category.builder().code("HOBBY").name("취미").build();
		
		Product product1=Product.builder().name("EXCEL").price(3000).stock(30).build();
		Product product2=Product.builder().name("WORD").price(6000).stock(23).build();
		Product product3=Product.builder().name("POWERPOINT").price(2000).stock(56).build();
		
		/*
		 * 연관관계설정
		 * Category-->Product
		 */
		category.getProducts().add(product1);
		category.getProducts().add(product2);
		category.getProducts().add(product3);
		
		product1.setCategory(category);
		product2.setCategory(category);
		product3.setCategory(category);
		System.out.println("--------------------save[CascadeType.PERSIST]-------------------");
		categoryRepository.save(category);
		categoryRepository.save(category2);
		
		System.out.println("--------------------read[CascadeType.PERSIST]-------------------");
		Category findCategory = categoryRepository.findById(1L).get();
		System.out.println("Category:"+findCategory);
		List<Product> productList= findCategory.getProducts();
		for (Product product : productList) {
			//product.setName("JPA!!!");
			System.out.println(product);
		}
		System.out.println("--------------------delete-------------------");
		System.out.println("--------------------부모엔티티삭제[CascadeType.REMOVE]-------------------");
		//categoryRepository.delete(findCategory);
		System.out.println("--------------------자식엔티티삭제[CascadeType.REMOVE]-------------------");
		/*
		productList.clear();
		List<Product> productList2= findCategory.getProducts();
		for (Product product : productList2) {
			//product.setName("JPA!!!");
			System.out.println(product);
		}
		*/
		
		
		System.out.println("--------------------부모엔티티삭제[orphanRemoval = true]-------------------");
		//categoryRepository.delete(findCategory);
		System.out.println("--------------------자식엔티티삭제[orphanRemoval = true]--------------------");
		//productList.remove(0);
		System.out.println("--------------------부모엔티티와자식엔티티연관관계제거[orphanRemoval = true]??-------------------");
		productList.get(0).setCategory(category2);
		
		
		
	}
}