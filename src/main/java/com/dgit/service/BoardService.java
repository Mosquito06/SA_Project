package com.dgit.service;

import java.util.List;

import com.dgit.domain.BoardVO;

public interface BoardService {
	public void insertBoard(BoardVO board) throws Exception;
	public void deleteBoard(BoardVO board) throws Exception;
	public void updateBoard(BoardVO board) throws Exception;
	public List<BoardVO> selectAll() throws Exception;
	public BoardVO selectBoardByBoardNum(int num) throws Exception;
	public List<BoardVO> selectBoardBySectionNum(int num) throws Exception;
	
}
