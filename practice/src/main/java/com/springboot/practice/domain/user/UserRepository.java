package com.springboot.practice.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

	// mapper의 이름과 같도록
	// 1. 회원가입시에 username 중복 확인 
	public int checkUsernameByUsername(String username);
	
	public int insertUser(User user);
	
	// username으로 user 찾기. 즉, 아이디 입력받은 값으로 디비에서 검색하기
	public User getUserByUsername(String username);
	
	// 
	public User getUserByUserId(int user_id);
	
	public UserDtl getUserDtlByUserId(int user_id);
	
	
	
	
	// accounts 부분은 회원정보 수정...
	public int updateUserByUserId(User user);
	// public int updateUserDtlById();
	public int updatePasswordByUserId(User user);
	
	// find 부분은 아이디 찾기
	public int findIdByNameAndEmail(String name, String email);
	public String getIdByNameAndEmail(String name, String email);
	
	// find 부분 비밀번호 찾기
	public int findPwByNameAndUsername(String name, String username);
	public int replacePersonalPwByUsername(String password, String username);
	
	
	
}
// repository는 service로 이동