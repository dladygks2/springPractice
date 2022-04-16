package com.spring.study.domain.user;

import java.util.List;
// 여기서는 메서드만 만들고 mapper에서 정함
// 그 mapper와 연결하는 것도 UserRepositoryImpl2 라는 클래스에서 함수를 만들어주고.
public interface UserRepository2 {

	public List<User> getUserAll(); // User롤 생성된 객체들을 모두 가져올 것이다.
	public int idCheck(String username);
	public int insertUser(User user);
	public int signin(User user);
	public User getUserByUsername(String username);
}
