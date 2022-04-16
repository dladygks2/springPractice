package com.springboot.practice.service;

import org.springframework.validation.BindingResult;

import com.springboot.practice.web.dto.auth.SignupReqDto;
import com.springboot.practice.web.dto.auth.SignupRespDto;

public interface AuthService {
	// 로그인과 회원가입에서 가능한 건지 확인하는 부분?????
	// 유효성 검사. 회원가입 유효성 검사.
	// 나중에 아이디나 비번 찾을 때도 여기서 등록.
	public SignupRespDto<?> validCheck(SignupReqDto signupReqDto, BindingResult bindingResult);
	
	// 
	 
}

