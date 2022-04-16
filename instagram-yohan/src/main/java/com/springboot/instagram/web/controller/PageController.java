package com.springboot.instagram.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.service.BoardService;
import com.springboot.instagram.service.ProfileService;
import com.springboot.instagram.web.dto.profile.ProfileRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller // view를 return하는 것이 기본값이다. view는 .jsp 파일을 의미. (템플릿인 jsp를 의미한다는데??) 
			// 즉 jsp를 return한다는 의미
public class PageController {

	private final BoardService boardService;
	private final ProfileService profileService;

	@GetMapping({ "/", "/index" }) // 이거 둘다 return "index"를 요청하는 것이다.
//	로그인만 되어있다면 '@AuthenticationPrincipal PrincipalDetails principalDetails' 
	// 얘를 세션이라고 생각하고 대입하면된단다.(21-12-24 03:46:46)
	public String indexForm(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		System.out.println("principalDetails.getUser() : " +
		principalDetails.getUser());
		System.out.println("principalDetails.getUsername() : " +
		principalDetails.getUsername());
		 
		return "index";  // views.index.jsp
		/*
		 * view: # 얘가 연결해주는 역할이구나 
		 * prefix: /WEB-INF/views/ 
		 * suffix: .jsp security:
		 * 얘는 application.yml 이다.
		 */
//		return "test";
	}

	// 이거 위 아래 기능이 같다.
	// @RequestMapping(value = "/auth/signin", method = RequestMethod.GET)
	@GetMapping("/auth/signin")  // signup.jsp 에서 58번쨰 줄에 사용한다. 연결해주는 역할
	public String signinForm() {
		return "auth/signin";
	}

	@GetMapping("/auth/signup")
	public String signupForm() {
		return "auth/signup";
	}

	@GetMapping("/accounts/edit") // PrincipalDetails principalDetails 여기에 계정 정보들이 담겨있다.
	public String accountsEditForm(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		return "accounts/accounts_edit"; // .jsp로 이동???
	}

	@GetMapping("/accounts/password/change")
	public String accountsPasswordForm() {
		return "/accounts/accounts_password";
	}

	@GetMapping("/upload")
	public String uploadForm() {
		return "upload/upload";
	}

	@GetMapping("/{username}")
	public String profileForm(Model model, @PathVariable String username,
			@AuthenticationPrincipal PrincipalDetails principalDetails) {
//		boardService.getProfileBoard(username);
//		session에 로그인이 성공하면 principalDetails 객체를 반환해준다????
		ProfileRespDto profileRespDto = null; // 선언후 초기화
		if (principalDetails != null && principalDetails.getUser().getUsername().equals(username)) {
//			principalDetails != null는 로그인상태라는 뜻,, username과 같다는 것은 내 아이디로 들어왔다는 거지
			profileRespDto = new ProfileRespDto();

			profileRespDto.setUsername(username);
			profileRespDto.setProfile_img(principalDetails.getUserDtl().getProfile_img());
			profileRespDto.setIntroduction(principalDetails.getUserDtl().getIntroduction());
			profileRespDto.setBoardTotalCount(boardService.getProfileBoardTotalCount(username)); // boardService.getProfileBoardTotalCount(username)여결로
																									// 갯수를 가져옴

			model.addAttribute("profileRespDto", profileRespDto);
			return "profile/my_profile"; // profile/my_profile ,,, jsp로 간다는 뜻.my_profile.jsp
		} else { // 남의 인스타에 들어왔다는 거다.
			profileRespDto = profileService.getProfile(principalDetails, username);
			profileRespDto.setBoardTotalCount(boardService.getProfileBoardTotalCount(username));

			model.addAttribute("profileRespDto", profileRespDto);
			return "profile/other_profile";
		}
	}

}
