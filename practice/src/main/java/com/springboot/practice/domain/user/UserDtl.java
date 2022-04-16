package com.springboot.practice.domain.user;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDtl {

	private int user_id; 
	
	private String profile_img;
	private String introduction;
	private String gender; 
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
}
