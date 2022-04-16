package com.spring.study.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller    // @Controller 이 어노테이션을 해줘야지 IoC에 등록된다.
public class AuthController2 {

//	post 요청에 관련된것.. url 주소가 같더라도 POST요청과 GET요청에 따라서 실행되는 메서드가 다르다.
	@RequestMapping(value = "/signup2", method = RequestMethod.POST)
	public String signup() {
		System.out.println("요청되었나요?? ");

		return null;
	}

	@RequestMapping(value = "/signup3", method = RequestMethod.GET)
	public String signup2(@RequestParam("username")String username ) {
		System.out.println("@RequestParam()은 요청의 parameter를 의미한다. ");
		System.out.println("username : " + username);
		return null;
	}
}
