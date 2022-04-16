package com.spring.study.web.dto.auth;
//요청때의 dto

import com.spring.study.domain.user.User;

import lombok.Data;

@Data
public class SignupReqDto {
	private String username;
	private String password;
	private String name;
	private String email;

	// signup.jsp에서 form태그에 중복확인 인지 회원가입인지 판별하기위한 flag
	private int submitFlag; 

	// 클라이언트의 요청을 Dto객체에 담아서 controller에 전달할 것이다.

	public SignupRespDto toResponseDto(boolean idCheckFlag) {
		return SignupRespDto.builder()
				.username(username)
				.password(password)
				.name(name)
				.email(email)
				.idCheckFlag(idCheckFlag)
				.build(); // .build(); 가 객체하나가 생성됨을 의미
	}

	public User toEntity() { // SignupReqDto 안의 값을 Entity 객체로 보내준다.
		return User.builder()
				.username(username)
				.password(password)
				.name(name)
				.email(email)
				.build();
	}
}
// jsp 에서 중점적으로 볼 것 : EL, JSTL