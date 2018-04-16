package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.BoardVO;
import com.dgit.domain.Criteria;

public interface BoardDao {
	public void insert(BoardVO board) throws Exception;
	public void delete(BoardVO board) throws Exception;
	public void update(BoardVO board) throws Exception;
	public void updateReadCount(int num) throws Exception;
	public void updateTotalCount(int num) throws Exception;
	public List<BoardVO> selectAll() throws Exception;
	public BoardVO selectBoardByBoardNum(int num) throws Exception;
	public List<BoardVO> selectBoardBySectionNum(int num, Criteria cri) throws Exception;
	public List<BoardVO> selectBoardByClientNum(int num) throws Exception;
	public int selectBoardCount(int num) throws Exception;
}
