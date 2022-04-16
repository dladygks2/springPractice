package com.springboot.instagram.boardstudy.db;

import java.time.LocalDateTime;

import lombok.Data;

//Entity의 역할을 한다.

@Data
public class BoardStudy {
	
	// board_mst를 join해서 들고올 것이다.
	private int board_id;
	private String board_img;
	private String board_content;
	
	private int user_id;
	private String username;
	private String profile_img;
	private LocalDateTime update_date;
}
