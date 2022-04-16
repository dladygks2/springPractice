package com.springboot.practice.domain.post;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Post {
	
	private int post_id;
	

	private String post_img;
	private String post_title;
	private String post_content;

	// 일단 viewPost 에서 딱히 쓸모없는거 같은데
	// private String profile_img;
	// private String username;  // 아이디(username)은 기본으로 가지고 있는건가
	
	private int user_id;
	
	private LocalDateTime create_date; // 하단부 파란글씨에 생성일자, 수정일자 넣자
	private LocalDateTime update_date;
	
}
