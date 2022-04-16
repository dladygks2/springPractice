package com.springboot.practice.domain.user;


import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {

	// 아... 왠지 회원가입 때 입력받을 거는 다 여기서 받아야하는 거 같은데????
	// 그렇구나... 
	private int user_id;
	
	private String username;
	private String name;
	private String password;

	private String phone;
	private String email;
	private String blog;
	
	private String role;

	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
