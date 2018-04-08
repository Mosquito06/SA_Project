package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.ReplyVO;

public interface ReplyDao {
	public void insert(ReplyVO reply) throws Exception;
	public void delete(ReplyVO reply) throws Exception;
	public void update(ReplyVO reply) throws Exception;
	public List<ReplyVO> selectAll() throws Exception;
	public List<ReplyVO> selectReplyByBoardNum(int num) throws Exception;
}
