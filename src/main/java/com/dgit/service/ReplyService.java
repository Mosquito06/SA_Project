package com.dgit.service;

import java.util.List;

import com.dgit.domain.Criteria;
import com.dgit.domain.ReplyVO;

public interface ReplyService {
	public void insertReply(ReplyVO reply) throws Exception;
	public void deleteReply(ReplyVO reply) throws Exception;
	public void updateReply(ReplyVO reply) throws Exception;
	public List<ReplyVO> selectAll() throws Exception;
	public List<ReplyVO> selectReplyByBoardNum(int num, Criteria cri) throws Exception;
	public int selectReplyCount(int boardNum) throws Exception;
	
}
