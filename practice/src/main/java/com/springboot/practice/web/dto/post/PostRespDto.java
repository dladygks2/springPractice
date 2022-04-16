package com.springboot.practice.web.dto.post;

public class PostRespDto<T> {
//	AuthServiceImpl.java 에서 
//	signupRespDto.setCode, .setData 에서 사용된다.
	private int code;
	private T data;
}
