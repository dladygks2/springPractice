package com.springboot.instagram.web.dto.accounts;

import lombok.Data;

@Data
public class PasswordRespDto {

//	private String prePassword;
//	private String newPassword;
//	
//	public User toEntity(int id) {
//		return User.builder()
//				.id(id)
//				.password(newPassword)
//				.build();
	
	private int code;
	private String message;
}

