package com.itwill.jpa.entity;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Guest {
	@Id
	@SequenceGenerator(name = "guest_guest_no_seq",sequenceName = "guest_guest_no_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "guest_guest_no_seq")
	private Long guestNo;
	private String guestName;
	@ColumnDefault("sysdate")
	private Date guestDate;
	private String guestEmail;
	private String guestHomepage;
	private String guestTitle;
	private String guestContent;
}
