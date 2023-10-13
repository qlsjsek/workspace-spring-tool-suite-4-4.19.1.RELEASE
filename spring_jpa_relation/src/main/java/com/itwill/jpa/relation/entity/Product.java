package com.itwill.jpa.relation.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Product extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long productId;
	
	private String name;
	private Integer price;
	private Integer stock;
	
	
	/*
	 * 1:1(OWNER TABLE 아님)
	 */
	@OneToOne(mappedBy = "product",cascade = CascadeType.PERSIST)
	private ProductDetail productDetail;
	
	
	/*
	 * N:1(OWNER TABLE)
	 */
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name="provider_id")
	@ToString.Exclude
	private Provider provider;
	

	/*
	 * N:1(OWNER TABLE)
	 */
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	 public void setCategory(Category category) {
	        // 기존 category 와 연관관계를 제거
	        if (this.category != null) {
	            this.category.getProducts().remove(this);
	        }

	        // 새로운 연관관계 설정
	        this.category = category;
	        if (category != null) {
	        	category.getProducts().add(this);
	        }
	    }
	
	
	
	
	
	
	
}