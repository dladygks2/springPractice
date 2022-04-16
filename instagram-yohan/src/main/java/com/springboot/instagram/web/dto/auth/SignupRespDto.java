package com.springboot.instagram.web.dto.auth;

import lombok.Data;

@Data
public class SignupRespDto<T> {
//	AuthServiceImpl.java 에서 
//	signupRespDto.setCode, .setData 에서 사용된다.
	private int code;
	private T data;
	
	
}
