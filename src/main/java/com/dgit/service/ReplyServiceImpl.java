package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.Criteria;
import com.dgit.domain.ReplyVO;
import com.dgit.persistence.ReplyDao;

@Repository
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDao dao;

	@Override
	public void insertReply(ReplyVO reply) throws Exception {
		dao.insert(reply);
		
	}

	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		dao.delete(reply);
		
	}

	@Override
	public void updateReply(ReplyVO reply) throws Exception {
		dao.update(reply);
		
	}

	@Override
	public List<ReplyVO> selectAll() throws Exception {
		return dao.selectAll();
	}

	@Override
	public List<ReplyVO> selectReplyByBoardNum(int num, Criteria cri) throws Exception {
		return dao.selectReplyByBoardNum(num, cri);
	}

	@Override
	public int selectReplyCount(int boardNum) throws Exception {
		return dao.selectReplyCount(boardNum);
	}

	@Override
	public ReplyVO selectReplyByReplyNum(int num) throws Exception {
		return dao.selectReplyByReplyNum(num);
	}

	
}
