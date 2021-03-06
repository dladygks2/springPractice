package com.springboot.practice.web.dto.post;


import org.springframework.web.multipart.MultipartFile;

import com.springboot.practice.domain.post.Post;
import com.springboot.practice.domain.user.UserDtl;

import lombok.Data;

@Data
public class PostReqDto {
// 입력해야하는 것들 request 이 3개만 있으면 되네 일단은
	
	private String post_img;
	private String post_title;
	private String post_content;
	 
	
	private MultipartFile file;
	
	// post를 이용해서 화면에 보여줄 값들은
	// 이미지, 제목, 내용, 프로필 이미지
	
	// post를 하는데에 user도 필요하고 post도 필요한 건가?
	// post 글 등록을 누가 할 것인가? => user 가 하지... 나는 일단 구분이 없구나
	public Post toEntityPost(int user_id, int post_id) { // id가 이거 2개 다 필요한건가?
		return Post.builder()
				.user_id(user_id)
				.post_id(post_id)
				.post_img(post_img)
				.post_title(post_title)
				.post_content(post_content)
				.build();
	}
	
	public UserDtl toEntityUserDtl(int user_id, String profile_img) {
		return UserDtl.builder() 
				.user_id(user_id)
				.profile_img(profile_img)
				.build();
	}
	
	
}
