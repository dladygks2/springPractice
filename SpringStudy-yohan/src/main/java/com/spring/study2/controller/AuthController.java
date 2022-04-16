package com.spring.study2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.study2.dto.SignupReqDto;

@Controller // Controller 어노테이션을 달아야 IoC에 등록이 되어서 사용이 된다.
public class AuthController {

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(SignupReqDto signupReqDto) {
		System.out.println("study2/AuthController/signup");
		System.out.println("POST 요청이다.");
		System.out.println("username : " + signupReqDto.getUsername());
		System.out.println("password : " + signupReqDto.getPassword());
		System.out.println("name : " + signupReqDto.getName());
		System.out.println("email : " + signupReqDto.getEmail());
		// /signup 페이지에서 얻은 이 값들이 signin으로 전달된다.
		return "auth3/signin"; // .jsp 파일에 위의 값들이 대입된다.
	}
	
	@RequestMapping(value = "/signup2", method = RequestMethod.GET)
	public String signup2(@RequestParam("username")String username , @RequestParam("password")String password, @RequestParam("name")String name, @RequestParam("email")String email) {
		System.out.println("study2/AuthController/signup");
		System.out.println("GET 요청이다.");
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		System.out.println("name : " + name);
		System.out.println("email : " + email);
		return null;
	}
	
	
}
