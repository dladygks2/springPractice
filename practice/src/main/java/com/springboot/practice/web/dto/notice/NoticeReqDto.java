package com.springboot.practice.web.dto.notice;

import java.time.LocalDateTime;

import com.springboot.practice.domain.notice.Notice;

import lombok.Data;

@Data
public class NoticeReqDto {

	private int notice_id;
	
	private String username; // 글 작성자.. 얘는 기존의 username으로 받을 건가...
	private LocalDateTime create_date;
	private String notice_title;
	private String notice_content;
	
	private int user_id;
		
	private LocalDateTime update_date;
	
	public Notice toNoticeEntity(int user_id) {
		return Notice.builder()
				.notice_id(user_id)
				.username(username)
				.notice_title(notice_title)
				.notice_content(notice_content)
				.build();
	}
	
}
