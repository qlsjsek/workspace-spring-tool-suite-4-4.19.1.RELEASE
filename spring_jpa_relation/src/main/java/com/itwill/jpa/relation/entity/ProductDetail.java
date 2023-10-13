package com.itwill.jpa.relation.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
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
public class ProductDetail extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long productDetailId;
	private String description;
	
	/*
	 * 1:1 owner table
	 */
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "product_id")
	@ToString.Exclude
	private Product product;
	
	@CreationTimestamp //insert시
	@Column(updatable = false)
	private LocalDateTime createAt;
	@UpdateTimestamp   //update시
	private LocalDateTime updateAt;
}
