package com.springboot.instagram.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.instagram.web.dto.TestDto;

// @RestController // 응답의 기본값은 data이다. @Controller는 기본값이 view resolver이다.controller는 .jsp를 반환
@Controller // 의 return "test"가 있으면 test.jsp 를 반환하는 건데
// @RestController 는 "get 요청" 같은 문자열을 반환한단다.
// AJAX 요청은 전부다 @RestController로 받을 것이다. JSON 데이터를 사용할 것이다.	 	
// pageController 부분만 @Controller를 사용하고 
// 나머지 부분은 @RestController 를 사용할 것이다. 
public class TestController {
	
	
	@GetMapping("/test-get2")
	public String testGet(){
		System.out.println("Get 요청옴2");
		return "get 요청2";
	//	@RestController는 JSP를 리턴할 수 없다. 
	//	view resolver를 리턴할 수 없다.
	//	JSP는 무조건 @Controller 가 있는 곳에서 리턴할 수 있다.
	//	페이지를 띄워주는 용도로만 사용할 것이다.
	}
	
	@PostMapping("/test-post2")
	public String testPost() {
		System.out.println("Post 요청옴2");
		return "post 요청2";
	}
	
	@PutMapping("/test-put2")
	public String testPut() {
		System.out.println("Put 요청옴2");
		return "put 요청2";
	}
	
	@DeleteMapping("/test-delete2")
	public String testDelete() {
		System.out.println("Delete 요청옴2");
		return "delete 요청2"; // jsp로 반환하는게 아니라 그냥 delete 요청이라는 String값이 반환됨.
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String testPage() {
		return "test";
	}
	
	@RequestMapping(value = "/test2-submit2", method = RequestMethod.POST)
	public String testSubmit(TestDto testDto) {
		System.out.println(testDto);
		return "test";
	}
}
