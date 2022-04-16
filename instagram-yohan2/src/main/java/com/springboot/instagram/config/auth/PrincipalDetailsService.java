package com.springboot.instagram.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserDtl;
import com.springboot.instagram.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor	// 밑에 final이고 인터페이스 객체인 애들이 선언된 애들한테만 사용가능하다. 
							// 상수선언해야 이것을 쓸 수 있다. 
							// 객체생성마다 @Autowired 하는 것이 귀찮기 때문에 사용한단다.
							// lombok으로 @Autowired한 상태이다.
@Service										// UserDetailsService 얘로 구현된 IoC가 따로 있는데 우리가 사용하기 위해서 이름을 PrincipalDetailsService로 대체시키겠다는 뜻.  
public class PrincipalDetailsService implements UserDetailsService {
	
	// DI 하는 거란다.
	private final UserRepository userRepository;
	
				// Username으로 User를 load 할 것이다. 
				// Username으로 조회를 해서 Session으로 등록하겠다.
	@Override	// 얘가 id를 확인한다. password도 확인한다.	다 되면 로그인 시킨다?
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = userRepository.getUserByUsername(username); // UserMapper.xml이랑 UserRepository에서 확인가능
		if(userEntity == null) {
			return null; // userEntity가 생성이 안되었으므로 error를 띄운다.
		}else {
			// 생성된 userEntity가 존재한다면, userDtlEntity를 생성할 것이다. 얘는 Id값으로 user의 detail값들을 얻을 수 있다.
			// PrincipalDetailsService를 UserDetailsService로 implements를 해줄 것이다.
			UserDtl userDtlEntity = userRepository.getUserDtlById(userEntity.getId()); 
			// 위의 애는 userEntity의 Id를 UserDtlById에 대입해서 생성하는 구나.
			return new PrincipalDetails(userEntity, userDtlEntity); // 시큐리티가 암호화된 패스워드. 로그인 됐는지 안됐는지.확인
		}// PrincipalDetails를 authentication이라는 session 객체에 집어넣는다???? 뭔소리지(2021-12-24 03:16:45)
		// PrincipalDetails <= 얘는 user, userDtl 들을 담을 수 있는 애다.
		// PrincipalDetails 얘는 UserDetails 얘를 상속받았다.
	}
}
// Security는 username 파라미터를 받으므로 id를 굳이 username으로 사용하는 것이다.