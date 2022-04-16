package com.springboot.practice.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practice.service.AuthService;
import com.springboot.practice.web.dto.auth.SignupReqDto;
import com.springboot.practice.web.dto.auth.SignupRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthContorller {

	private final AuthService authService;
	
	@PostMapping("/signupPage")
	public Object signup(@Valid SignupReqDto signupReqDto, BindingResult bindingResult) {
		// signupReqDto의 정보가 valid 체크를 해서 오류가 나면 binding으로 넘긴다.
		System.out.println("signupReqDto : " + signupReqDto);
		System.out.println("bindingResult : " + bindingResult);
		
		if(bindingResult.hasErrors()) {
			System.out.println("유효성 검사 오류");
			
			Map<String, String> errorMap = new HashMap<String, String>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			SignupRespDto<Map<String , String>> signupRespDto = new SignupRespDto<Map<String,String>>();
			signupRespDto.setCode(400);
			signupRespDto.setData(errorMap);
			
			return signupRespDto;
		}else {
			System.out.println("유효성 검사 성공");
			
		}
		return authService.validCheck(signupReqDto, bindingResult);
	}
	
	// 정보를 불러오는 것은 GET Mapping을 사용한다.
	// 여기서 username & PW 찾기를 한다.
	
}
