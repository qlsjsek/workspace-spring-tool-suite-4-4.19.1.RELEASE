package com.itwill.jpa.entity;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
//@Entity
public class Board {
	@Id
	@GeneratedValue
	private Long boardno;
	private String title;
	private String writer;
	private String content;
	private LocalDateTime regdate;
	private Long readcount;
	private Long groupno;
	private Long step;
	private Long depth;
}
