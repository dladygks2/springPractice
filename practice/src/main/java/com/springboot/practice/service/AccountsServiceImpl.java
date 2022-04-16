package com.springboot.practice.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.practice.config.auth.PrincipalDetails;
import com.springboot.practice.domain.user.User;
import com.springboot.practice.domain.user.UserDtl;
import com.springboot.practice.domain.user.UserRepository;
import com.springboot.practice.web.dto.accounts.PasswordReqDto;
import com.springboot.practice.web.dto.accounts.PasswordRespDto;
import com.springboot.practice.web.dto.accounts.ProfileReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountsServiceImpl implements AccountsService {

	// service에서 repository를 불러와서 값들을 넣어줄 것이다.
	private final UserRepository userRepository;

	@Value("${file.path")
	private String filePath;

	@Override
	public boolean usernameCheck(String username) {
		// 이 밑의 checkUsernameByUsername은 mapper에서 있으면 1 없으면 0 으로 반환해주는거 아마도???
		int result = userRepository.checkUsernameByUsername(username);

		if (result == 0) {
			return true;
		} else {
			return false;
		}
	}

	// principalDetails에 이전의 프로필 사진이 저장되어있다.
	public void deleteProfileImgFile(PrincipalDetails principalDetails) {
		String imgUrl = principalDetails.getUserDtl().getProfile_img();
		System.out.println(imgUrl);

		if (!imgUrl.equals("profile_img\\default.jpg")) {
			File file = new File(filePath + imgUrl);
			if (file.exists()) {
				file.delete();
			}
		}
	}

	// updateUser
	@Override
	public boolean updateUser(PrincipalDetails principalDetails, ProfileReqDto profileReqDto) {

		int id = principalDetails.getUser().getUser_id();
		String password = principalDetails.getUser().getPassword();
		String profile_img = principalDetails.getUserDtl().getProfile_img();
		User userEntity = profileReqDto.toUserEntity(id, password);
		UserDtl userDtlEntity = null;
		int result = 0;

		if (profileReqDto.getFile() == null) {
			profile_img = principalDetails.getUserDtl().getProfile_img();
		} else {
			// UUID = 고유 키값을 잡아주는 ID, 파일명이 겹칠일이 없도록
			// 여기서 파일 생성이 된다.
			String imageFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_"
					+ profileReqDto.getFile().getOriginalFilename();
			Path imageFilePath = Paths.get(filePath, "profile_img\\" + imageFileName);

			File file = new File(filePath + "profile_img");
			if (!file.exists()) {
				file.mkdirs();
			}

			try {
				Files.write(imageFilePath, profileReqDto.getFile().getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}

			profile_img = "profile_img\\" + imageFileName;

		}

		userDtlEntity = profileReqDto.toUserDtlEntity(id);

		result += userRepository.updateUserByUserId(userEntity);

		if (result == 1) {
			principalDetails.setUser(userEntity);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean prePasswordCheck(String principalPassword, String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder.matches(password, principalPassword);
	}
	
	// 비밀번호 변경하는 부분
	public boolean passwordCheck(String principaPassword, String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(password, principaPassword);
	}
	
	// 비밀번호 변경하는 부분
	@Override
	public PasswordRespDto updatePassword(PrincipalDetails principalDetails, PasswordReqDto passwordReqDto) {

		boolean prePasswordCheckFlag = passwordCheck(principalDetails.getPassword(), passwordReqDto.getPrePassword());
		
		return null;
	}
	
	

}
