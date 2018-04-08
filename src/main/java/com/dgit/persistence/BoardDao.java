package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.BoardVO;

public interface BoardDao {
	public void insert(BoardVO board) throws Exception;
	public void delete(BoardVO board) throws Exception;
	public void update(BoardVO board) throws Exception;
	public List<BoardVO> selectAll() throws Exception;
	public BoardVO selectBoardByBoardNum(int num) throws Exception;
	public List<BoardVO> selectBoardBySectionNum(int num) throws Exception;
}