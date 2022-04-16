package com.springboot.practice.web.dto.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.practice.domain.user.User;

import lombok.Data;

@Data
public class SignupReqDto {

	// signup.jsp에서 입력받은 애들을 넣어줄 것
	
	private int user_id;
	
	@NotBlank
	@Size(min = 4, max = 10)
	private String username;
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Size(min = 7, max=20)
	private String password;
	
	@NotBlank
	@Size(min = 10, max = 11)
	private String phone;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String blog; 
	
	
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.name(name)
				.password(new BCryptPasswordEncoder().encode(password))
				.phone(phone)
				.email(email)
				.blog(blog)
				.role("ROLE_USER")
				.build();
	}
	
	
}
