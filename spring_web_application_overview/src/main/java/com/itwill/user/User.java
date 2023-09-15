package com.itwill.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter @Getter
@ToString
public class User {
	private Integer id;
	private String name;
}
