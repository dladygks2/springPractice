package com.springboot.instagram.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.domain.board.Board;
import com.springboot.instagram.domain.board.BoardRepository;
import com.springboot.instagram.domain.board.IndexBoard;
import com.springboot.instagram.domain.board.ProfileBoard;
import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserDtl;
import com.springboot.instagram.domain.user.UserRepository;
import com.springboot.instagram.web.dto.board.BoardReqDto;
import com.springboot.instagram.web.dto.board.BoardRespDto;
import com.springboot.instagram.web.dto.board.IndexBoardRespDto;
import com.springboot.instagram.web.dto.profile.ProfileBoardRespDto;
import com.springboot.instagram.web.dto.profile.ProfileRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
	
	private final BoardRepository boardRepository;
	private final UserRepository userRepository;
	
	@Value("${file.path}")
	private String filePath;
	
	@Override
	public boolean insertBoard(PrincipalDetails principalDetails, BoardReqDto boardReqDto) {
		// 파일명 주는 거
		String imgFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + boardReqDto.getFile().getOriginalFilename();
		String boardImg = "board_img\\" + imgFileName;
		
		Path imgFilePath = Paths.get(filePath, boardImg);  // imgFilePath 라는 이름의 파일을 만들어라??
		
		File file = new File(filePath + "board_img");
		if(!file.exists()) {
			file.mkdirs();  // makedirectorys 파일을 만들어라는 코드
		}
		
		try {
			Files.write(imgFilePath, boardReqDto.getFile().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Board boardEntity = boardReqDto.toEntity(principalDetails.getUser().getId(), boardImg);
		
			int result = boardRepository.insertBoard(boardEntity);
			if(result == 1) {
				return true;
			}else {
				return false;
			}
					
	}
	
	@Override
	public int getProfileBoardTotalCount(String username) {
		List<ProfileBoard> boardList = boardRepository.getProfileBoardListByUsername(username);
		/*
		 * ProfileRespDto profileRespDto = new ProfileRespDto();
		 * profileRespDto.setBoardTotalCount(boardList.size());
		 */
		 return boardList.size();
		}
	
	@Override
	public ProfileBoardRespDto getProfileBoard(String username, int page) {
		// 해당 페이지에 맞는 board를 받아올 것이다.
		List<ProfileBoard> boardListAll = boardRepository.getProfileBoardListByUsername(username);
		//위의 boardRepository.getProfileBoardList... HeidySql에서 user_mst의 모든 값을 받아온다는 뜻이란다. 
		List<List<ProfileBoard>> boardGroup = new ArrayList<List<ProfileBoard>>();
		int boardListTotalCount = boardListAll.size();
		int groupSize = (boardListTotalCount % 3) == 0 ? boardListTotalCount / 3 : (boardListTotalCount / 3 ) + 1 ;
		
		int startIndex = page * 3;
		int endIndex = startIndex + 3;
		
		int j = startIndex * 3;
		
		// 이 i 에 pageNumber가 들어올 것이다.
		// groupSize = page + 3 이 될 것이다.
		for (int i = startIndex; i < endIndex && i < groupSize; i++ ) {
			List<ProfileBoard> boardList = new ArrayList<ProfileBoard>();
			
			for(; j < (i + 1) * 3 && j < boardListTotalCount; j++) {
				boardList.add(boardListAll.get(j));
			}
			boardGroup.add(boardList);
		} 
		return new ProfileBoardRespDto(boardGroup);
	}
	
	 @Override
	public BoardRespDto getBoard(int boardId) {
		BoardRespDto boardRespDto = boardRepository.getBoardById(boardId).toBoardRespDto();
		User userEntity = userRepository.getUserById(boardRespDto.getUserId());
		UserDtl userDtlEntitiy = userRepository.getUserDtlById(userEntity.getId());
		boardRespDto.setUsername(userEntity.getUsername());
		boardRespDto.setProfileImg(userDtlEntitiy.getProfile_img());
		return boardRespDto;
		// 이 dto에는 좋아요, 댓글 등등의 정보가 들어갈 것이다.
	}

	@Override
	public IndexBoardRespDto getIndexBoardList(String username, int page) {
		List<IndexBoard> indexBoardListAll = boardRepository.getIndexBoardListByUsername(username);
		
		int indexBoardListTotalCount = indexBoardListAll.size();
		int startIndex = page * 3;
		int endIndex = startIndex + 3;
		
		List<IndexBoard> indexBoardList = new ArrayList<IndexBoard>();
		for(int i = startIndex ; i < endIndex && i < indexBoardListTotalCount ; i++) {
			indexBoardList.add(indexBoardListAll.get(i));
		}
		IndexBoardRespDto indexBoardRespDto = new IndexBoardRespDto();
		indexBoardRespDto.setIndexBoardList(indexBoardList);
		indexBoardRespDto.setIndexBoardTotalCount(indexBoardListTotalCount);
		return indexBoardRespDto;
	}
}
	

