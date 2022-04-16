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

@Controller   // 이걸 해줘야(component이다.) - 이 클래스가 IoC에 등록된다.
public class AuthController {
// 인증과 관련된 부분이다.

	@Autowired    // ioc안에 해당 AuthService라는 인터페이스로 되어있는 객체가 필요
	private AuthService authService;

	// url주소값이 같아도 post로 요청했느냐 get으로 요청했느냐에 따라서 요청값이 달라진다.
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(Model model, SignupReqDto signupReqDto) {
		System.out.println("요청됨1?????");
		System.out.println("username : " + signupReqDto.getUsername());
		System.out.println(signupReqDto);

		if(signupReqDto.getSubmitFlag() == 1) {
//			아이디 중복확인(select) 하는곳
		   SignupRespDto signupRespDto = authService.usernameCheck(signupReqDto);

		   // signupRespDto 객체안에 ReqDto정보들을 넣어놨으니 얘들을 들고 가야지
		   // model 객체로 들고 간다.
		   model.addAttribute("signupRespDto", signupRespDto); //("key값", value값);

		   return "auth/signup";

		}else {
//			회원가입 진행(insert)
			boolean signupSuccessFlag = authService.signup(signupReqDto);
			if(signupSuccessFlag) {
				return "redirect:/signin";
			}else {
				return "auth/signup";
			}
		}

		// 한글 깨진 이유 tomcat이 UTF-8 지원안해줌 그래서 중간에 변경을 해줘야함
		// web.xml에서
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin( Model model, HttpServletRequest request ,SigninReqDto signinReqDto) {
//		return "index/index";

		SigninRespDto signinRespDto = authService.signin(signinReqDto);

		if(signinRespDto.getSigninFlag() == 2) {
//			로그인 성공... 그러면 세션을 만들어주어야한다.
//			세션저장소에 user entity 가 들어있어야한다. 유저정보
//			domain.user > User.java

			HttpSession session = request.getSession(); // 서버가 클라이언트한테 세션키값을 발급했고, 그 세션키값을 요청하는 것.
			                                            // 위의 request안에 세션값이 있다.
//			session에 유저정보가 있다. id로 유저정보를 조회할 것이다.
			User loginUser = authService.getUserByUsername(signinRespDto.getUsername());
			session.setAttribute("principal", loginUser);
			return "redirect:/index"; // 로그인 성공했으니 메인페이지로 이동해야지

		}

		model.addAttribute("signinRespDto", signinRespDto);


//		Massege<User> userMessage = new Massege<User>(); 
		return "auth/signin"; // 로그인 성공시에
	}


//	@RequestMapping(value = "/signup2", method = RequestMethod.GET)
//	public String signup2(@RequestParam("username") String username, @RequestParam("password") String password) {
//		System.out.println("GET방식 요청됨2222?????");
//		System.out.println("username : " + username);
//		System.out.println("password : " + password);
//		return null;
//	}
	@ResponseBody
	@RequestMapping(value = "/signup/username-check", method = RequestMethod.GET)
	public Object signupAjax(SignupReqDto signupReqDto) {
//		데이터만 전달하는 어노테이션 : @ResponseBody
		/* System.out.println(signupReqAjaxDto); */

		SignupRespDto signupRespDto = authService.usernameCheck(signupReqDto);
		return signupRespDto;  
		// signupAjax.js 에서 usernameCheck메서드에서 signupRespDto를 JSON 형태로 받는다.
	}

//	@ResponseBody,@RequestBody ::: AJAX에서 JSON데이터를 전달 받을때
//	request로 받을 때는 @RequestBody를 써야함
//
	@ResponseBody
	@RequestMapping(value="/signin/ajax", method = RequestMethod.POST)
	public Object signinAjax(@RequestBody SigninReqDto signinReqDto, HttpServletRequest request) {
		SigninRespDto signinRespDto = authService.signin(signinReqDto);
		if(signinRespDto.getSigninFlag() == 2) {
			HttpSession session = request.getSession();
			User loginUser = authService.getUserByUsername(signinRespDto.getUsername());
			session.setAttribute("principal", loginUser);  // principal이라는 이름으로 loginUser객체를 담는다.
		}
		return signinRespDto;
	}
}






















