package com.springboot.instagram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.instagram.config.oauth2.PrincipalOauth2UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity // 해당파일로 시큐리티 활성화. 즉, SecurityConfig가 활성화된다. 기존의 시큐리티 관련 설정 대신에 얘가 그역할을 할거다라는 뜻
@Configuration  // IoC 컨테이너에 등록하는것
// 설정관련 객체를 등록하는데에 사용한다.
// 상속이 필수이다. SecurityConfig 이름은 다른 것으로 해도 무방하지만 상속은 꼭 받아라.
// WebSecurityConfigurerAdapter 얘가 IoC에 미리 등록이 되어있다.
// 얘가 내가 직접 만들지 않은 로그인 폼 형태를 가지고 있다.

// @Configuration 을 하면 이 기본 설정은 날라가고, 내가 새로 등록한 것이 사용된다.
// 즉, IoC에 SecurityConfig 얘가 등록되는 것
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final PrincipalOauth2UserService principalOauth2UserService;
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();   
		// 이거는 시큐리티가 '암호를 사용하기 위해서 필요한 코드'이다.
	}
	
	@Override  //security 설정 객체, configure메서드를 재정의해줘야한다. 그것이 이 밑의 부분
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();  // csrf 토큰은 사용하지 않겠다.
		http.authorizeRequests()  // GET요청시에 서버에 인증요청이 들어오면. 모든 요청을 인증검사를 하겠다.(2021년 12월 23일 01시간 37분 26초부터)
			.antMatchers("/", "/index","/accounts/**", "/upload/**", "/follow/**") // (GET 요청시에)이런 요청들이 들어오면 session을 먼저 체크하고
			.authenticated()	         // 위에 애들은 모두 인증 과정을 거쳐라. 통과 못하면 formLogin으로 바로감
			.anyRequest()				// 그 외에 다른 요청들은
			.permitAll()				// 권한을 허가해주어라. 즉 위의 경우를 제외하고는 다 권한을 허가해주어라. 얘들은 인증없이 들어갈수 있는 페이지를 말함.
			.and()						// 
			.formLogin()				// 로그인 화면은 요청이 필요하면 formLogin을 실행하도록, 위의 antMatchers를 보면 쟤들 빼고는 인증없이 들어갈수 있도록
			.loginPage("/auth/signin")  // 로그인 페이지는 이쪽으로 보내라(이 페이지를 로그인 페이지로 하겠다). get요청 : 해당 get요청으로 응답해준다. 페이지 띄워주는 요청
			.loginProcessingUrl("/auth/signin")  // url에 동일하지만 위와는 다른 접근 ...post요청 : signin.jsp에서 로그인 submit 요청 시에 Post요청으로 /auth/signin 요청을 해라 
												 // 얘가 principaldetailsService.java를 실행... 무슨 관계인데 이게 ㅅㅂ 
			.defaultSuccessUrl("/")	// 인증이 성공하면 해당 url로 이동해라. / == 인덱스이라는데
			.and()
			.oauth2Login()   // auth 폴더에 signin.jsp에 페이스북 로그인 버튼을 만들어놨는데
			.loginPage("/auth/signin")
			.userInfoEndpoint()  // 여기에서 모든 request가 날라온다. principalOauth2UserService의 loadUser가 넘어온다.
			/*
			 *  1. 코드받기(인증코드)
			 *  우리의 사이트에서 네이버로 코드를 요청한다.
			 *  2. 엑세스 토큰을 발급(접근 권한을 부여해줌)해준다.
			 *  3. 이것으로 사용자 정보(프로필)을 가져온다.             1.~3. 까지는 userInfoEndpoint()에서 해준다.
			 *  4. 사용자 프로필 정보를 가지고 우리 사이트에 자동으로 회원가입을 진행한다.     4. 는 UserService에서 해준다.
			 */
			.userService(principalOauth2UserService)
			.and()
			.defaultSuccessUrl("/");
	}
}
