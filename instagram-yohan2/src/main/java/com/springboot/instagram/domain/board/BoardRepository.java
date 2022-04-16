package com.springboot.instagram.domain.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {
	// insertBoard 이거 BoardMapper.xml 의 insert의 id와 같다.
	// insertBoard의 parameterType = "com.springboot.instagram.domain.board.Board"
	public int insertBoard(Board board);
	
	// 얘도 BoardMapper.xml 에서 선언되어 있구나....
	public List<ProfileBoard> getProfileBoardListByUsername(String username);
	public Board getBoardById(int boardId);
	public List<IndexBoard> getIndexBoardListByUsername(String username);
}
