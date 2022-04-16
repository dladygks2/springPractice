package com.springboot.instagram.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserDtl;

import lombok.Data;
//import lombok.NoArgsConstructor;
//@NoArgsConstructor 
@Data   // getter, setter, equal, toString, (또 하나) 만들어준다.
public class PrincipalDetails implements UserDetails, OAuth2User{ // UserDetails, OAuth2User 얘들도 IoC에서 이미 구비된 녀석들
// authentication 이라는 Session에 PrincipalDetails라는 객체가 들어간다.
	
//	얘가 .jsp에서 ${principal.~~} 이거로 사용할 수 있도록 하는 건가보네
//	얘를 쓰기 위해서는 태그 라이브러리를 dependency에 등록해야한다. mvnrepository에서
//	security taglibs로 검색
//	Spring Security Taglibs 를 사용할 것이다.
//	pom.xml에서 사용한다.
	
	private static final long serialVersionUID = 1L; // tomcat이 객체들을 관리할 때 사용하는 것. 내가 신경쓸 것 아니다
	
	private User user;  // DB에서 들고와서 주입할 것이다.
	private UserDtl userDtl;
	private Map<String, Object> attributes;
	
	// PrincipalDetails가 생성될 때 user 객체를 받아서 생성된다. 
	public PrincipalDetails(User user, UserDtl userDtl) {
		this.user = user;
		this.userDtl = userDtl;
	}
	
	public PrincipalDetails(User user, UserDtl userDtl, Map<String, Object> attributes) {
		this.user = user;
		this.userDtl = userDtl;
		this.attributes = attributes;
	}
	
	// Collection 은 list, set의 부모 인터페이스이다. 여러개의 데이터를 담을 수 있는 인터페이스이다.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 권한 설정하는 것. 시큐리티가 사용하는 거라는데 이 메서드들은 시큐리티가 사용하도록 하기위해서 생성한 것이다.
		
		Collection<GrantedAuthority> collection = new ArrayList<GrantedAuthority>();
		collection.add(new GrantedAuthority() { // 인터페이스라서 객체 생성이 안되므로 무명 클래스를 사용해서 객체 생성을 한단다.
			private static final long serialVersionUID = 1L;
			@Override
			public String getAuthority() {  // 얘가 GrantedAuthority의 무명 클래스인듯.
				
				return user.getRole();  // "ROLE_USER"인지 관리자인지
			}
		});
		return collection;
	}

	@Override
	public String getPassword() {
		return user.getPassword(); // PrincipalDetails에서 user 값을 받을 거
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

//	 이 밑에 4개 애들 중에 return이 false가 하나라도 있으면 계정이 만료된다. 만료되면 해당 username으로 로그인 못함
	
	@Override
	public boolean isAccountNonExpired() {
		// 계정이 만료되었는지 확인하는 곳이다. 계정을 완전히 못쓰게 만드는 것. isEnabled 얘랑 비교
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// 예를 들어서 비밀번호 5번 이상 틀리면 잠김기능 같은거 설정하는 것. 
		// (return false;)되면 잠금이 된다.
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 자격증명 만료가 되지는 않았는지 확인
		// OTP 인증, 2차 인증 같은거 할 때 사용
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 휴면계정인지 아닌지 확인. 계정을 잠시 정지시키는 것. isAccountNonExpired 얘랑 비교
		// true인 상태가 사용이 가능한 상태이다.
		return true;
	}



	@Override
	public Map<String, Object> getAttributes() { 
		return attributes;
	}



	@Override
	public String getName() {
		return (String)attributes.get("name");
	}
	
}
