package com.spring.study.domain.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl2 implements UserRepository2{

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAME_SPACE = "com.spring.study.domain.user.UserRepository2.";
	
	@Override
	public List<User> getUserAll() {
		// TODO Auto-generated method stub
//		return sqlSession.selectOne(null); // 결과값이 한개일 경우
		return sqlSession.selectList(NAME_SPACE + "getUserAll"); // 결과값이 여러개일 경우
		// 위의 괄호 안에는 namespace + id 값의 형식으로 입력해줘야한다.
		// namespace는 <mapper>에 있다. 
		// <mapper namespace="com.spring.study.domain.user.UserRepository2">
	}

	@Override
	public int idCheck(String username) {
		// TODO Auto-generated method stub
		// mybatis를 통해서 쿼리가 실행되도록 해야한다.
		// 이 return에서 "" 안의 값이 repository에서 mybatis로 보내는 과정이다.
		return sqlSession.selectOne(NAME_SPACE + "idCheck", username);
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAME_SPACE + "insertUser",user);
	}

	@Override
	public int signin(User user) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne( NAME_SPACE + "signin",user);
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAME_SPACE + "getUserByUsername" + username);
	}

}
