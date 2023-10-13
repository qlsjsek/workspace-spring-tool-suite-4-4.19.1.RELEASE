package com.itwill.jpa.relation.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
@Data
@MappedSuperclass
public class BaseEntity {
	@CreationTimestamp //insert시
	@Column(updatable = false)
	private LocalDateTime createAt;
	@UpdateTimestamp   //update시
	private LocalDateTime updateAt;
}
