package com.itwill.jpa.entity;

import java.time.LocalDateTime;

public class Product {
    private Long productId;
    private String name;
    private Integer price;
    private Integer stock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
