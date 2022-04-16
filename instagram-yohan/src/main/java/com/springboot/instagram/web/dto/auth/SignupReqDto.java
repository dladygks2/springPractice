package com.springboot.instagram.web.dto.auth;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.instagram.domain.user.User;

import lombok.Data;
// 2021_12_23 웹앱개발  03:12:00~
@Data
public class SignupReqDto {
//	얘들은 signup.jsp에서 입력받는 애들을 작성할 것이다.
//	입력받는 것을 보니까 .su-login-form에서 
//	.su-input으로 name값에 email, nama, username, password를 받는다.
	
//	@NotNull은 blank 값도 입력값으로 인식한다.
	
	@NotBlank // 빈값일 수 없다.  -> @Valid에서 체크하기 위해서 사용한다.
	private String email;
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Size(min = 4, max = 20)
	private String username;
	
	@NotBlank
	private String password;
//	usermst???? HeidiSQL에서???
	
	
	// AuthService에서 User userEntity = signupReqDto.toEntity(); 로 사용되네
	public User toEntity() {
		return User.builder()
				.email(email)
				.name(name)
				.username(username)
				.password(new BCryptPasswordEncoder().encode(password))
				.role("ROLE_USER")   // 관리자들은 필요없지만 회원가입을 하는 회원들은 USER의 역할을 지정받는다.
				.build(); 
	}  // AuthController.java에 가서
}
