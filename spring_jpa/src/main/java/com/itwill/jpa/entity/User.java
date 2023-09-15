package com.itwill.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
@RequiredArgsConstructor
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name = "users")
@SequenceGenerator(	name = "users_id_SEQ_gen",
					sequenceName ="users_id_SEQ",
					initialValue = 1 ,
					allocationSize = 1)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "users_id_SEQ_gen")
	@Column(name = "id")
	private Long id;
	
	@NonNull
	@Column(nullable = false)
	private String name;
	@NonNull
	private String email;
	
	
	private LocalDateTime createdAt;
	
	
	private LocalDateTime updatedAt;
	
}
