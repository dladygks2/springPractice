package com.springboot.practice.domain.notice;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Notice {

	// 공고글의 id이다.
	private int notice_id;
	private String username;
	
	// NoticeMapper.xml 에서 id로 insertNotice 나 뭐 이런거 ???
	private String notice_title; 
	private String notice_content;
	// private int user_id;
	// 이거 username 도 뽑아내야하는 건가? 작성자에 뭐 적어야하긴하는데 일단 뺴고 해보자
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
}
