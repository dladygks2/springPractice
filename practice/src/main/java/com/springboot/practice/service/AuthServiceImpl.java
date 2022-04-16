package com.springboot.practice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.springboot.practice.domain.user.User;
import com.springboot.practice.domain.user.UserRepository;
import com.springboot.practice.web.dto.auth.SignupReqDto;
import com.springboot.practice.web.dto.auth.SignupRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

	// 유효성 검사. 회원가입 유효성 검사.
	// 나중에 아이디나 비번 찾을 때도 여기서 등록.
	private final UserRepository userRepository;

	@Override
	public SignupRespDto<?> validCheck(SignupReqDto signupReqDto, BindingResult bindingResult) {
		// 회원가입정보의 유효성 확인
		if (bindingResult.hasErrors()) { // 결과 자체에서 문제가 존재한다.
			Map<String, String> errorMap = new HashMap<String, String>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			} // 에러들을 errorMap에 담는다.
			SignupRespDto<Map<String, String>> signupRespDto = new SignupRespDto<Map<String, String>>();
			signupRespDto.setCode(444);
			signupRespDto.setData(errorMap);
			return signupRespDto;

			// signupRespDto는
			// AuthServiceImpl.java 에서
			// signupRespDto.setCode, .setData 에서 사용된다.

		} else { // 회원가입이 가능하거나 DB에 이미 존재하는 경우. 코드의 문제는 아니다.
			// username을 가져옴. 
			int checkUsernameResult = userRepository.checkUsernameByUsername(signupReqDto.getUsername());
			SignupRespDto<String>signupRespDto = new SignupRespDto<String>();
			if(checkUsernameResult == 0) {
				// DB 확인 후에 결과가 없으면 0. 즉, username 사용가능
				User userEntity = signupReqDto.toEntity();
				userRepository.insertUser(userEntity);
				signupRespDto.setCode(001);
				signupRespDto.setData("회원가입 완료");
			}else {
				// 회원가입 실패
				signupRespDto.setCode(002);
				signupRespDto.setData("이미 존재하는 아이디입니다.");
			}
			return signupRespDto;
		}

	}
}