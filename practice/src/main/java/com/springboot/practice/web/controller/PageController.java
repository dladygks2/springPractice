package com.springboot.practice.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.practice.config.auth.PrincipalDetails;
import com.springboot.practice.web.dto.accounts.ProfileRespDto;

@Controller
public class PageController {

	@GetMapping({ "/", "/main", "/index" })
	public String mainForm(@AuthenticationPrincipal PrincipalDetails principalDetails) {

		System.out.println("main.jsp로 연결하는 건가?");

		return "main";
	}

	@GetMapping("/signinPage")
	public String signinForm() {
		System.out.println("signinPage로 연결?");
		return "signinPage";
	}

	/*
	 * @GetMapping("/signupPage") public String signupForm() {
	 * System.out.println("signupPage로 연결?"); return "signupPage"; }
	 */
	@GetMapping("/makePost")
	public String makePost() {
		System.out.println("makePost로 연결");
		return "makePost";
	}

	@GetMapping("/accountsEdit")
	public String accountsEdit(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		System.out.println("accountsEdit으로 연결");
		return "accountsEdit";
	}

	@GetMapping("/accountsPassword")
	public String accountsPassword() {
		System.out.println("accountsPassword");
		return "accountsPassword";
	}

	@GetMapping("/notice")
	public String notice() {
		System.out.println("notice");
		return "notice";
	}

	@GetMapping("/noticeInput")
	public String noticeInput() {
		System.out.println("noticeInput");
		return "noticeInput";
	}

	@GetMapping("/noticeRead")
	public String noticeRead() {
		System.out.println("noticeRead");
		return "noticeRead";
	}

	@GetMapping("/viewPost")
	public String viewPost() {
		System.out.println("viewPost");
		return "viewPost";
	}

	// 개인 아이디로 로그인해서 프로필을 볼 수 있는 화면?
/*
	@GetMapping("/{username}")
	public String profileForm(Model model, @PathVariable String username,
			@AuthenticationPrincipal PrincipalDetails principalDetails) {
		// session에 로그인이 성공하면 principalDetails 객체를 반환해준다.????
		ProfileRespDto profileRespDto = null;
		if (principalDetails != null && principalDetails.getUser().getUsername().equals(username)) {
			profileRespDto = new ProfileRespDto();

			profileRespDto.setUsername(username);
			profileRespDto.setProfile_img(principalDetails.getUserDtl().getProfile_img());
			profileRespDto.setPhone(principalDetails.getUser().getPhone());
			
			model.addAttribute("profileRespDto", profileRespDto);
			return "main";
		} else {
			profileRespDto = profileService.getProfile(principalDetails, username);
			profileRespDto.setBoardTotalCount(boardService.)
		}
	}
*/
}
