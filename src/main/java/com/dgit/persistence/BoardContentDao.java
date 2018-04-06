package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.BoardContentVO;

public interface BoardContentDao {
	public void insert(BoardContentVO boardContent) throws Exception;
	public void delete(BoardContentVO boardContent) throws Exception;
	public void update(BoardContentVO boardContent) throws Exception;
	public List<BoardContentVO> selectAll() throws Exception;
	public BoardContentVO selectboardContentByBoardNum(int num) throws Exception;
}
