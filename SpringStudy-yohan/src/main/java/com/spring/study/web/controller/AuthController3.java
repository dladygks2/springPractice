package com.spring.study.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.study.domain.user.User;
import com.spring.study.service.auth.AuthService;
import com.spring.study.web.dto.auth.SigninReqDto;
import com.spring.study.web.dto.auth.SigninRespDto;
import com.spring.study.web.dto.auth.SignupReqDto;
import com.spring.study.web.dto.auth.SignupRespDto; 

@Controller
public class AuthController3 {
	
	@Autowired
	private AuthService authService;

	@RequestMapping(value = "/signup4", method = RequestMethod.POST)
	public String signup(Model model, SignupReqDto signupReqDto) {
		if(signupReqDto.getSubmitFlag() == 1) {
			// 아이디 중복확인(select)
			// controller에서 로직처리하지 않음 service에서 할 것이다.
			SignupRespDto signupRespDto = authService.usernameCheck(signupReqDto);
			
			model.addAttribute("signupRespDto", signupRespDto);
			
			return "auth3/signup";
		}else {
			// 회원가입진행(insert) 기본값
			boolean signupSuccessFlag = authService.signup(signupReqDto);
			if(signupSuccessFlag == true) {
				return "redirect:/sign:";
			}else {
				return "auth3/signup";
			}
			
		}		
	}
	
	// 로그인 성공시
	@RequestMapping(value ="/signin4" , method = RequestMethod.POST)
	public String signin(Model model, HttpServletRequest request ,SigninReqDto signinReqDto ) {
		
		SigninRespDto signinRespDto = authService.signin(signinReqDto);
		
		if(signinRespDto.getSigninFlag() == 2) {
			// 로그인 성공이므로 세션을 만들어준다.
			// 세션 저장소에 userEntity가 들어있어야한다. User의 정보.
			// HttpServletRequest 를 사용한다.
			
			HttpSession session = request.getSession(); // 서버가 처음에 request를 받았으면 세션 키값을 클라이언트에게 보냈을 거고
			// .getSession 으로 request(요청)의 세션키값을 얻을 수 있다. (세션 키값은 request 안에 들어있단다.)
			// 이 session 변수에 클라이언트의 세션값이 있다..
			// 이 session에 user의 정보를 넣어두어야한다.
			// user 정보는 id를 가지고 조회를 해야한다.
			// UserMapper2.xml 에서 설정을 해준다.
			
			// principal 이라는 이름으로 loginUser 객체를 session에 등록한 것이다.
			User loginUser = authService.getUserByUsername(signinRespDto.getUsername());
			session.setAttribute("principal", loginUser);
			return "redirect:/index";
		
		}
		
		model.addAttribute("signinRespDto", signinRespDto);
		  
		return "auth3/signin"; // 로그인 성공시
	}
	
	@ResponseBody // return으로 view resolver로 페이지 전달하는 것이 아니라 진짜 String 값을 전달한다.
	@RequestMapping(value = "/signup/username-check2", method = RequestMethod.GET)
	public Object signupAjax(SignupReqDto signupReqDto ){  // Object로 전달되면 'JSON' 형태로 전달된다.
		System.out.println(signupReqDto);
		SignupRespDto signupRespDto = authService.usernameCheck(signupReqDto);
		return signupRespDto;
	}
	
	@ResponseBody
	@RequestMapping(value = "/signin/ajax2", method = RequestMethod.POST)
	public Object signinAjax(@RequestBody SigninReqDto signinReqDto, HttpServletRequest request) {
		System.out.println(signinReqDto);
		SigninRespDto signinRespDto = authService.signin(signinReqDto);
		if(signinRespDto.getSigninFlag() == 2) {
			HttpSession session = request.getSession();
			User loginUser = authService.getUserByUsername(signinRespDto.getUsername());
			session.setAttribute("principal", loginUser);
			
		}
		return signinRespDto;
	} 
}
