package com.itwill.ajax.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "News Domain")
public class News {
	@Schema(description = "뉴스번호")
	private int no;
	private String title;
	private String company;
	private String date;
	
	
}
/*
@Getter
@AllArgsConstructor
@Schema(description = "Member profile update request")
public class MemberProfileUpdateReq {
 
  @NotBlank(message = "사용자 이름을 입력해주세요.")
  @Length(max = 20, message = "사용자 이름은 20글자 이하로 입력해야 합니다.")
  @Schema(description = "member name", example = "John Doe")
  private String name;
 
  @NotBlank(message = "사용자 닉네임을 입력해주세요.")
  @Length(max = 20, message = "사용자 닉네임은 20글자 이하로 입력해야 합니다.")
  @Schema(description = "member nickname", example = "johndoe")
  private String nickname;
 
  @NotBlank
  @Schema(description = "member profile emoji", example = "👨🏻‍💻")
  private String profileEmoji;
}
 */
