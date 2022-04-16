package com.springboot.instagram.domain.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
// DB에서 가져올 것들
@Mapper        // UserRepository의 각각의 메서드들이 mapper에서 똑같이 사용된다.	
public interface UserRepository {
//	1
	public int checkUsernameByUsername(String username); // username이 담기면 1 인가?? AuthServiceImpl에서 사용됨
//	2
	public int insertUser(User user);    // AuthServiceImpl에서 사용됨
//	3
	public User getUserByUsername(String username); // user 객체를 데리고 오는거
//	4
	public User getUserByOAuth2Username(String oauth2_username);
//	5
	public User getUserById(int id);
//	6
	public UserDtl getUserDtlById(int id);
	
	
//	account
//	7
	public int updateUserById(User user);
//	8
	public int updateUserDtlById(UserDtl userDtl);
//	9
	public int updatePasswordById(User user);
	
	// follow
//	10
	public int follow(Subscribe subscribe);
//	11
	public int followCancel(Subscribe subscribe);
//	12
	public Subscribe getFollow(Subscribe subscribe);
}
