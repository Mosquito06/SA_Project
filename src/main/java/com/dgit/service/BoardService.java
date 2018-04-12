package com.dgit.service;

import java.util.List;

import com.dgit.domain.BoardVO;
import com.dgit.domain.CreateBoard;
import com.dgit.domain.Criteria;

public interface BoardService {
	public void insertBoard(CreateBoard createBoard) throws Exception;
	public void deleteBoard(BoardVO board) throws Exception;
	public void updateBoard(BoardVO board) throws Exception;
	public List<BoardVO> selectAll() throws Exception;
	public BoardVO selectBoardByBoardNum(int num) throws Exception;
	public List<BoardVO> selectBoardBySectionNum(int num, Criteria cri) throws Exception;
	public int selectBoardCount(int num) throws Exception;
	
}
