package com.spring.study.service.auth;

import java.util.Map;

import com.spring.study.domain.user.User;
import com.spring.study.web.dto.auth.SigninReqDto;
import com.spring.study.web.dto.auth.SigninRespDto;
import com.spring.study.web.dto.auth.SignupReqDto;
import com.spring.study.web.dto.auth.SignupRespDto; 

public interface AuthService {
	// signup
	public SignupRespDto usernameCheck(SignupReqDto signupReqDto);
	
	// authController에서 인증으로 들어오면 authServiceImpl에서
	public boolean signup(SignupReqDto signupReqDto);
	
	// signin
//	public int signin(SigninReqDto signinReqDto);
//	public SigninRespDto signin(SigninReqDto signinReqDto);
	
	public SigninRespDto signin(SigninReqDto signinReqDto);
	

	// getuser
	public User getUserByUsername(String username);
	
	

}
