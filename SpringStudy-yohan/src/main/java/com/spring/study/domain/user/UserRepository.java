package com.spring.study.domain.user;

import java.util.List;


public interface UserRepository {

	public List<User> getUserAll(); // 매핑할 메서드를 생성
	public int idCheck(String username);
	public int insertUser(User user);  // 몇 건이 insert 됐는지 확인하는것
	public int signin(User user);
	public User getUserByUsername(String username);
}
