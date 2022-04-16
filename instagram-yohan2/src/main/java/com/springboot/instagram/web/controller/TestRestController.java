package com.springboot.instagram.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.instagram.web.dto.TestDto;

@RestController  // @Controller 응답의 기본값은 view resolver 이다. 그래서 jsp파일로 연결이되는 것이다.
public class TestRestController {
	/*
	 * 여기에 있는 애들은 
	 * SecurityConfig.java에서 
	 * .antmatchers에 포함되지 않으므로 그냥 접근이 가능한 애들이다.
	 * 
	 * mapping의 종류인가
	 * 
	 * @ResponseBody
		@RequestMapping(value= "/test1", method = RequestMethod.GET )
	 * ==> 
		@RestController
	 * 
	  * postman에서 실행해본 결과 
	  * .jsp 는 get / post / head 요청만 가능하다. 즉, 얘들만 .jsp파일로 응답을 해줄 수 있다.
	  * */
	@RequestMapping(value= "/test1", method = RequestMethod.GET )
	public String testPage() {
		return "test"; // test.jsp를 반환한다는 뜻이다.
	}
	
	@RequestMapping(value = "/test-submit", method = RequestMethod.POST)
	public String testSubmit(TestDto testDto) {
		System.out.println(testDto);
		return "test";
	}
	
	@GetMapping("/test-get")
	public String testGet(){
		System.out.println("Get 요청옴");
		return "test";
	}
	
	@PostMapping("/test-post")
	public String testPost() {
		System.out.println("Post 요청옴");
		return "test";
	}
//	put 요청과 delete요청을 사용하기 위해서 rest 라는 것을 사용한단다. rest API
//	일종의 약속
	@PutMapping("/test-put")
	public String testPut() {
		System.out.println("Put 요청옴");
		return "test";
	}
	
	@DeleteMapping("/test-delete")
	public String testDelete() {
		System.out.println("Delete 요청옴");
		return "test";
	}
}

