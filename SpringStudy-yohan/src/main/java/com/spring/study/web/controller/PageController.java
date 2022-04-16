package com.spring.study.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Component  // 딱히 역할이 없는 경우에 사용

//// 대표적인 컴포넌트 4가지
//@Controller // 페이지에 관련된 것들. request, response에 관계하는 것에 단다
//@Service	// 로직들을 처리하는 부분들을 의미한다. DB를 받은 것을 로직(함수)등 요청을 받은대로 처리해서 준다.
//@Repository // DB와 소통해서 데이터를 찾아온다. service에게 넘긴다.
//@Configuration // 웹에서 사용되는 설정을 하는 역할.

@Controller
public class PageController {

//	@Autowired   // UserRepositoryImpl을 사용한 게 userRepository 밖에 없기때문에 @Autowired로 해도된다.
//	private UserRepository userRepository;

	@RequestMapping(value= "/index", method = RequestMethod.GET)
	public String indexForm() {
//		List<User>userList = userRepository.getUserAll();
		return "index/index";
	}
	// sign in
	@RequestMapping(value = "/signin", method =RequestMethod.GET )
	// 밑에 메서드를 먼저 작성하면 method에 입력하는게 단축키 설정가능하다
	public String signinForm() {
		return "auth/signin";
	}

	// sign up
	@RequestMapping(value = "/signup", method =RequestMethod.GET )
	// 밑에 메서드를 먼저 작성하면 method에 입력하는게 단축키 설정가능하다
	public String signupForm() {
		return "auth/signup";  // view reserver 의 주소?
	}

	@RequestMapping(value = "/signup-ajax", method =RequestMethod.GET )
	// 밑에 메서드를 먼저 작성하면 method에 입력하는게 단축키 설정가능하다
	public String signupAjaxForm() {
		return "auth/signupAjax";  // view reserver 의 주소?
	}

	@RequestMapping(value = "/signin-ajax", method =RequestMethod.GET )

	public String signinAjaxForm() {
		return "auth/signinAjax";
	}




	// get 요청 & post 요청
//	get = 주소창에 찍어서 보내는 것은 전부다 get방식
//	post = 주소창에 보낼 수 없다.


}
