package com.springboot.instagram.config.oauth2;

import java.util.Map;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.config.oauth2.provider.OAuth2UserDto;
import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserDtl;
import com.springboot.instagram.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
	
	private final UserRepository userRepository;
	
	 @Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(userRequest);
		Map<String, Object> oAuth2UserAttributes = oAuth2User.getAttributes();
		String provider = userRequest.getClientRegistration().getRegistrationId();
		String providerId = null;
		System.out.println("Attributes: " + oAuth2UserAttributes);
		if(provider.equals("naver")) {
			oAuth2UserAttributes = (Map<String, Object>)oAuth2UserAttributes.get("response");
			providerId = (String)oAuth2UserAttributes.get("id");   // id, sub는 키값을 의미한다.
		}else if(provider.equals("google")) {
			providerId = (String)oAuth2UserAttributes.get("sub");  // sub는 구글에서 부여하는 내 계정의 키값이다. 중복가능성없다. 
		}else if(provider.equals("facebook")) {
			providerId = (String)oAuth2UserAttributes.get("id");
		}else {
			providerId = UUID.randomUUID().toString().replace("-", "");
		}
		
		String oauth2_username = provider + "_" + providerId;
		
		OAuth2UserDto oAuth2UserDto = OAuth2UserDto.builder()
				.oauth2_username(oauth2_username)
				.email((String)oAuth2UserAttributes.get("email"))
				.name((String)oAuth2UserAttributes.get("name"))
				.provider(provider)
				.role("ROLE_USER")
				.build();
		
		User userEntity = userRepository.getUserByOAuth2Username(oauth2_username);
		if(userEntity == null) {
			userEntity = oAuth2UserDto.toEntity();
			userEntity.setPassword(new BCryptPasswordEncoder().encode("1234"));
			userRepository.insertUser(userEntity); // null로 회원가입이 되어있지 않을 때에 회원가입시키는 것
			userEntity = userRepository.getUserByOAuth2Username(oauth2_username);
		}
		UserDtl userDtlEntity = userRepository.getUserDtlById(userEntity.getId());
		
		return new PrincipalDetails(userEntity, userDtlEntity, oAuth2UserAttributes);
	}
}
