package com.dgit.service;

import java.util.List;

import com.dgit.domain.BoardContentVO;

public interface BoardContentService {
	public void insertBoardContent(BoardContentVO boardContent) throws Exception;
	public void deleteBoardContent(BoardContentVO boardContent) throws Exception;
	public void updateBoardContent(BoardContentVO boardContent) throws Exception;
	public List<BoardContentVO> selectAll() throws Exception;
	public BoardContentVO selectboardContentByBoardNum(int num) throws Exception;
	
}
