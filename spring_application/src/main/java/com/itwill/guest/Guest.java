package com.itwill.guest;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class Guest {
	@NonNull
	private Integer guest_no;
	@NonNull
	private String guest_name;
	private String guest_date;
	private String guest_email;
	private String guest_homepage;
	private String guest_title;
	private String guest_content;
	
	
	
	
}
