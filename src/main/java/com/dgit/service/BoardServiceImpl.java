package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dgit.domain.AddFileVO;
import com.dgit.domain.BoardVO;
import com.dgit.domain.Criteria;
import com.dgit.persistence.AddFileDao;
import com.dgit.persistence.BoardDao;

@Repository
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao dao;
	
	@Autowired
	private AddFileDao addFileDao;

	@Override
	public void insertBoard(BoardVO board) throws Exception {
		dao.insert(board);
		
	}

	@Override
	public void deleteBoard(BoardVO board) throws Exception {
		dao.delete(board);
		
	}

	@Override
	public void updateBoard(BoardVO board) throws Exception {
		dao.update(board);
		
	}

	@Override
	public List<BoardVO> selectAll() throws Exception {
		return dao.selectAll();
	}

	@Override
	public BoardVO selectBoardByBoardNum(int num) throws Exception {
		return dao.selectBoardByBoardNum(num);
	}

	@Override
	@Transactional
	public List<BoardVO> selectBoardBySectionNum(int num, Criteria cri) throws Exception {
		
		List<BoardVO> boards = dao.selectBoardBySectionNum(num, cri);
		for(BoardVO b : boards){
			List<AddFileVO> files = addFileDao.selectAddFileByBoardNum(num);
			if(files != null){
				b.setFiles(files);
			}
		}
		
		return boards;
	}

	

	
}
