package com.springboot.instagram.boardstudy.db;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper  // IoC에도 등록된다.
public interface BRepository {
//	리스트를 통째로 들고 올거란다. BoardStudy클래스로 생성된 객체의... 
	public List<BoardStudy> getBoardList();
}
