package com.springboot.instagram.service;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.web.dto.board.BoardReqDto;
import com.springboot.instagram.web.dto.board.BoardRespDto;
import com.springboot.instagram.web.dto.board.IndexBoardRespDto;
import com.springboot.instagram.web.dto.profile.ProfileBoardRespDto;

public interface BoardService {
	public boolean insertBoard(PrincipalDetails principalDetails, BoardReqDto boardReqDto);
	public int getProfileBoardTotalCount(String username);
	public ProfileBoardRespDto getProfileBoard(String username, int page);
	public BoardRespDto getBoard(int board_id);  // query는 대소문자 구문 안함
	public IndexBoardRespDto getIndexBoardList(String username, int page);
}
