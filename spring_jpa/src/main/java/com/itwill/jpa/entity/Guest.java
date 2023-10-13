package com.itwill.jpa.entity;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

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

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@DynamicUpdate //update시 필요한 내용만 update작업
public class Guest {
	@Id
	@SequenceGenerator(name = "guest_guest_no_seq",sequenceName = "guest_guest_no_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "guest_guest_no_seq")
	private Long guestNo;
	private String guestName;
	@ColumnDefault("sysdate")
	//@Column(columnDefinition = "date default sysdate")
	@CreationTimestamp //insert시 자동으로 값을 채워줌
	private Date guestDate;
	private String guestEmail;
	private String guestHomepage;
	private String guestTitle;
	private String guestContent;
}
