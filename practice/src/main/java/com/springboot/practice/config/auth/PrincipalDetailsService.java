package com.springboot.practice.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.practice.domain.user.User;
import com.springboot.practice.domain.user.UserDtl;
import com.springboot.practice.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService{
	
	// DI 하는 거라는데
	private final UserRepository userRepository;
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User userEntity = userRepository.getUserByUsername(username);
		if(userEntity == null) {
			return null;
		}else {
			UserDtl userDtlEntity = userRepository.getUserDtlByUserId(userEntity.getUser_id());
		return new PrincipalDetails(userEntity, userDtlEntity);
		}
		
	}

	
}

/*
 * @RequiredArgsConstructor는 밑에 final이고, interface 객체인 애들이 선언된 클래스에서 사용이 가능하다.
 * 상수선언을 해야지 사용할 수 있다...
 * 객체 생성을 할 때마다 @Autowired 하는 것이 귀찮기 떄문에 사용한다.
 * lombok으로 @Autowired한 상태이다.
 * 
 * */ 
 