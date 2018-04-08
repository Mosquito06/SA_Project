package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.BoardContentVO;
import com.dgit.persistence.BoardContentDao;

@Repository
public class BoardContentServiceImpl implements BoardContentService {
	
	@Autowired
	private BoardContentDao dao;

	@Override
	public void insertBoardContent(BoardContentVO boardContent) throws Exception {
		dao.insert(boardContent);
		
	}

	@Override
	public void deleteBoardContent(BoardContentVO boardContent) throws Exception {
		dao.delete(boardContent);
		
	}

	@Override
	public void updateBoardContent(BoardContentVO boardContent) throws Exception {
		dao.update(boardContent);
		
	}

	@Override
	public List<BoardContentVO> selectAll() throws Exception {
		return dao.selectAll();
	}

	@Override
	public BoardContentVO selectboardContentByBoardNum(int num) throws Exception {
		return dao.selectboardContentByBoardNum(num);
	}

	

	
}
