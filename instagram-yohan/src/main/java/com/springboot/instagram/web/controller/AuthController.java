package com.springboot.instagram.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.instagram.service.AuthService;
import com.springboot.instagram.web.dto.auth.SignupReqDto;
import com.springboot.instagram.web.dto.auth.SignupRespDto;

import lombok.RequiredArgsConstructor;

//  중요 ***** controller는 최대한 깔끔하게 service에서 전부다 처리해줄 것이다.

@RequiredArgsConstructor    // 밑에 final이고 인터페이스 객체인 애들이 선언된 애들한테만 사용가능하다. 
							// 상수선언해야 이것을 쓸 수 있다. 
							// 객체생성마다 @Autowired 하는 것이 귀찮기 때문에 사용한단다.
							// lombok으로 @Autowired한 상태이다.

@RestController      	 	// data를 반환하는 애란다. 
							// @RestController는 view를 반환하는 controller가 아니다. 무조건 data를 반환
							// @ResponseBody 태그를 @PostMapping 위에 달아준거랑 똑같은 역할을 한다.
public class AuthController {
//	인증이니까 로그인페이지? 
	//@RequiredArgsConstructor 는 
	// 여기에 @Autowired 해준 것과 같다.
	private final AuthService authService;

//	회원가입은 입력이기 때문에 post요청을 받아야한다.???
	@PostMapping("/auth/signup") // signup == 가입하기, 입력을 받을거기 때문에 @PostMapping을 한다.	 
//	객체전달을 받을 것이다.
	
//	validation 사용하기 위해서는 인터넷에서 mvnrepository 검색해서 
//	validation 라이브러리를 추가했기때문에 사용할 수 있는 것
//	validation을 사용하기 위해서는 @Valid를 밑에 처럼 달아줘야한다.

	//	BindingResult는 validation체크를 signupReqDto로 헀을 때 
//	문제가 생기면 사용된다.
//	즉, 오류의 결과를 bindingResult에 넘긴다. 
//	이거 만들고 signupRespDto 작업을 하는 듯.
	public Object signup(@Valid SignupReqDto signupReqDto, BindingResult bindingResult) {
//		signupReqDto에서 email, name, username, password를 받을 것이다. 
//		받기위한 요청은 JavaScript에서 한다.
//		이 정보들을 받는 것을 AJAX를 사용해서 받았다.
//		signup.js에서
		System.out.println("signupReqDto : " + signupReqDto);
//		signupReqDto : SignupReqDto(email=abc@naver.com, name=김준일, username=testID, password=123123) 이렇게 담긴다.
		System.out.println("bindingResult : " + bindingResult);
//		bindingResult : org.springframework.validation.BeanPropertyBindingResult: 0 errors
//		error가 없다는 정보를 같이해서 넘기는구나
		
		if(bindingResult.hasErrors()) {
			System.out.println("Validation Check Error........");
//			SignupReqDto 에서 @NotBlank를 달아줬기 때문에 빈값일시에 에러뜸
			
			Map<String, String> errorMap = new HashMap<String, String>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			} // .getField() 는 변수명을 가져온다는 뜻. 
			// .getDefaultMessage() 는 어떤 error인지 설명해주는 기본값 같은거란다.
			
			SignupRespDto<Map<String, String>> signupRespDto = new SignupRespDto<Map<String, String>>();
			signupRespDto.setCode(400);
			signupRespDto.setData(errorMap);
			
			return signupRespDto;
			
		}else {
			System.out.println("Validation Check Success");
//			이 경우에만 service를 호출할 것이다. 
//			domain에 repository만들어서 그녀석을 통해서 DB에 값을 넣고,
//			회원가입이 완료되면 Login 사이트로
		}
		
//		validation이 가능할 때에 service를 호출할 것이다.
//		domain 패키지에서 Repository를 만들어서 DB에다가 값을 넣고,
//		정상적으로 회원가입이 완료되면 로그인 페이지로 넘어가도록
		return authService.validCheck(signupReqDto, bindingResult);
		// @RestController는 알아서 Object로 반환되는 return을 JSON 데이터로 반환한다.
		
//		얘는 signup.js를 사용해서 받을 건가보다.
	}
}

// 2021_12_23 웹앱개발3의 03:09:58 부터 이 부분 시작한다. 

// AuchController 를 만들었으면 => Dto를 만들어준다. 
// auth 패키지에 SignupReqDto SignupRespDto를 만들어준다. 