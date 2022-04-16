package com.springboot.practice.service;

import com.springboot.practice.config.auth.PrincipalDetails;
import com.springboot.practice.web.dto.accounts.PasswordReqDto;
import com.springboot.practice.web.dto.accounts.PasswordRespDto;
import com.springboot.practice.web.dto.accounts.ProfileReqDto;

public interface AccountsService {

// 회원정보 수정
// username 중복 확인
	
	public boolean usernameCheck(String username);
	
	public boolean updateUser(PrincipalDetails principalDetails, ProfileReqDto profileReqDto);
	public PasswordRespDto updatePassword(PrincipalDetails principalDetails, PasswordReqDto passwordReqDto);
	
	
}
