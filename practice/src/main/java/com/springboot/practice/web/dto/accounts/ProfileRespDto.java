package com.springboot.practice.web.dto.accounts;

import lombok.Data;

@Data
public class ProfileRespDto {
	
	private int user_id;
	private String username;
	private String profile_img;
	private String phone;
	private String email;
	// 카톡이랑 블로그도 넣어야 하는가...
}
