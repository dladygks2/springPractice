package com.spring.study.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PageController2 {
//	/index2 로 요청을 보내면 indexForm이라는 메서드를 찾아낸다.
//	@Controller가 /index2 주소를 요청받은대로 indexForm 메서드를 실행하도록 되어있다.

	@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public String indexForm() {
		return "index2/index2";

//		indexForm 메서드가 실행될 때 dispatcherServlet이 request를 받으면
//		model이라는 객체를 하나 생성을 한다.
//		dispatcherServlet에서 component로 넘길때 메서드에서는 매개변수로 model을 전달하라
//		tomcat이 해당 서버를 실행하면서 servlet호출하면서 request객체를 보내준다.
//		위의 model객체는 생성되면 전역변수로 생성이된다.
//		그래서 model.addAttribute 이거는 전역에다가 해주는것이다.
//		dispatcher가 들고 있는것이다. return할 필요없고, view reserver에게 경로만 알려주면된다.
//		servlet-context.xml에서
	}

	@RequestMapping(value = "/signin2", method = RequestMethod.GET) // value는 요청주소가 된다.
	public String signinForm() {
		return "auth2/signin"; //view resolver에게 넘길 주소값이 필요
	}

	@RequestMapping(value = "/signup2", method = RequestMethod.GET) // value는 요청주소가 된다.
	public String signupForm() {
		return "auth2/signup"; //view resolver에게 넘길 주소값이 필요
	}

}





