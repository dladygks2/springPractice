package com.spring.study.service.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.study.domain.user.User;
import com.spring.study.domain.user.UserRepository2;
import com.spring.study.web.dto.auth.SigninReqDto;
import com.spring.study.web.dto.auth.SigninRespDto;
import com.spring.study.web.dto.auth.SignupReqDto;
import com.spring.study.web.dto.auth.SignupRespDto; 

@Service // 이게 있어야 DI가 가능하단다.
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository2 userRepository2;

	@Override
	public SignupRespDto usernameCheck(SignupReqDto SignupReqDto) {
		int idCheckCount = userRepository2.idCheck(SignupReqDto.getUsername());
		if (idCheckCount == 0) {
//			회원가입 가능한 ID
//			return SignupReqDto.toDto(true);
			return SignupReqDto.toResponseDto(true);
		} else {
//			이미 존재하는 ID
			return SignupReqDto.toResponseDto(false);
		}
	}

	@Override
	public boolean signup(SignupReqDto signupReqDto) {
		// signupReqDto를 이제 Entity로 옮겨줘야한다.
		// User.java에서 builder 패턴으로 Entity의 값들을 옮겨줄 것이다.
		// User.java에 @builder 추가해주고 -> SignupReqDto로 이동해준다.
		// Dto를 받으면 User 객체로 바꾸어줘야한다.
		User userEntity = signupReqDto.toEntity();
		// 이 값을 이제 repositoryImpl에 전달을 하고 Insert를 할 것이다.

		int insertCount = userRepository2.insertUser(userEntity);
		// mapper가 UserRepository2와 연결되어 있고, 이 메서드가 실행되면 DB에 전달되는 것이다.

		if (0 < insertCount) {
			System.out.println("insert 성공");
			return true;
		} else {
			System.out.println("insert 싫패");
			return false;
		}
	}

	/*
	 * @Override public SigninRespDto signin(SigninReqDto signinReqDto) {
	 * 
	 * return null; }
	 */
	 

	@Override
	public SigninRespDto signin(SigninReqDto signinReqDto) {

		// userEntity로 조회를 할 것이다.
		User userEntity = signinReqDto.toEntity();
		int signinFlag = userRepository2.signin(userEntity); 
		
		SigninRespDto signinRespDto = signinReqDto.toResponseDto(signinFlag);
		
		return signinRespDto;
	}
	
	@Override
	public User getUserByUsername(String username) {
		return userRepository2.getUserByUsername(username);
	}

}
