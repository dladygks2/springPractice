package com.springboot.instagram.domain.user;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder // insert할 때 user객체로 전달해야하기때문에 @Builder를 사용한다.
@Data
public class User {
	
	private int id;
	
	private String email;
	private String name;
	private String username;
	private String oauth2_username;
	private String password;
	private String provider;
	private String role;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
//	entity객체이기 떄문에 DB의 tbl과 같은 형태를 가지고 있어야한다. 	
}
