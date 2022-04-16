package com.springboot.instagram.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserRepository;
import com.springboot.instagram.web.dto.auth.SignupReqDto;
import com.springboot.instagram.web.dto.auth.SignupRespDto;

import lombok.RequiredArgsConstructor;

// 여기까지 만들고 나면 signup.js로 간다.


@RequiredArgsConstructor    // 밑에 final이고 인터페이스 객체인 애들이 선언된 애들한테만 사용가능하다. 
// 상수선언해야 이것을 쓸 수 있다. 
// 객체생성마다 @Autowired 하는 것이 귀찮기 때문에 사용한단다.
// lombok으로 @Autowired한 상태이다.
@Service			// serviceImpl에다가 @Service 달아준다.
public class AuthServiceImpl implements AuthService {

//	DI를 해준단다. checkUsernameResult에서 사용하기 위해서
	private final UserRepository userRepository;
	
	@Override  // 로그인에 반응해주는 Dto???
	// signupRespDto<?> :: ?는 나중에 if - else 에 따라서 생성할 ArrayList가 달라져서 그런가?
	public SignupRespDto<?> validCheck(SignupReqDto signupReqDto, BindingResult bindingResult) {
		// 위의 ?(물음표)는 return의 자료형에 맞춰서 정해질 것이다.
		if(bindingResult.hasErrors()) {
			// 밸리데이션 체크 실패의 경우
			Map<String, String> errorMap = new HashMap<String, String>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			SignupRespDto<Map<String, String>>signupRespDto = new SignupRespDto<Map<String,String>>();
			signupRespDto.setCode(400);  	// signup.js에서 signupDataObj.code 로 사용한다.
			signupRespDto.setData(errorMap);
		
			return signupRespDto;
		
		}else {
			// System.out.println("벨리데이션 체크 성공");  // 중복확인
			int checkUsernameResult = userRepository.checkUsernameByUsername(signupReqDto.getUsername());// UserRepository에서 확인 가능
			// signup(로그인??)요청을 받은 애의 username을 넣은 checkUsernameByUsername 메서드가 username이 존재하면 1, 없으면 0??
			
			// SignupRespDto의 애들을 사용할 수 있는 String return을 하는 ArrayList???라는 건가?
			SignupRespDto<String> signupRespDto = new SignupRespDto<String>();
			
			if(checkUsernameResult == 0) {
				// 회원가입 가능, 0이라는 것은 존재하지 않는다는 것이므로 회원가입이 가능하다.
				// 존재하는 값이 아니다는 뜻	
				User userEntity = signupReqDto.toEntity(); // signupReqDto(회원가입 요청Dto)로 입력된 값들을 받을 객체 생성
				
				userRepository.insertUser(userEntity); // UserRepository에서 확인 가능
				signupRespDto.setCode(200);		// signup.js에서 signupDataObj.code 로 사용한다.
				signupRespDto.setData("회원가입 성공");
				
			}else {
				// 회원가입 불가능(username 중복)
				signupRespDto.setCode(401);		// signup.js에서 signupDataObj.code 로 사용한다.
				signupRespDto.setData("이미 존재하는 아이디입니다.");
			}
			return signupRespDto; 
		}
		 
	}
}
