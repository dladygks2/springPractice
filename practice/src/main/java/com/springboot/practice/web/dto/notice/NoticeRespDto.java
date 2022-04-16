package com.springboot.practice.web.dto.notice;

public class NoticeRespDto<T> {
//	AuthServiceImpl.java 에서 
//	signupRespDto.setCode, .setData 에서 사용된다.
	private int code;
	private T data;
}
