package com.dgit.service;

import java.util.List;

import com.dgit.domain.BoardVO;
import com.dgit.domain.CreateBoard;
import com.dgit.domain.Criteria;
import com.dgit.domain.MaxVO;
import com.dgit.domain.UpdateBoard;

public interface BoardService {
	public void insertBoard(CreateBoard createBoard) throws Exception;
	public void deleteBoard(BoardVO board, String rootPath) throws Exception;
	public void updateBoard(UpdateBoard updateBoard) throws Exception;
	public List<BoardVO> selectAll() throws Exception;
	public BoardVO selectBoardByBoardNum(int num, boolean readCheck) throws Exception;
	public List<BoardVO> selectBoardBySectionNum(int num, Criteria cri) throws Exception;
	public List<BoardVO> selectBoardNoCriBySectionNum(int num) throws Exception;
	public List<BoardVO> selectBoardByClientNum(int num) throws Exception;
	public int selectBoardCount(int num) throws Exception;
	public MaxVO selectMaxTotalCount() throws Exception;
	
}
