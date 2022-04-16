package com.springboot.practice.web.dto.accounts;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.practice.domain.user.User;

import lombok.Data;

@Data
public class PasswordReqDto {

//	비밀번호를 바꾸는 데에 사용할 것이다.
	private String prePassword;
	private String newPassword;
	
	public User toEntity(int user_id) {
		return User.builder()
				.user_id(user_id)
				.password(new BCryptPasswordEncoder().encode(newPassword))
				.build();
	}
}
