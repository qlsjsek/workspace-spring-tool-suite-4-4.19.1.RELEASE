package com.itwill.jpa.dto;

import com.itwill.jpa.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductResponseDto {

    private Long productId;

    private String name;

    private int price;

    private int stock;
    
    public static ProductResponseDto toDto(Product entity) {
    	
    	return ProductResponseDto.builder()
    								.productId(entity.getProductId()) 
    								.name(entity.getName())
    								.price(entity.getPrice())
    								.stock(entity.getStock())
    								.build();
    }
}
