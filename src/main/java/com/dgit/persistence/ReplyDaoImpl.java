package com.dgit.persistence;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.CategoryVO;
import com.dgit.domain.Criteria;
import com.dgit.domain.DivisionVO;
import com.dgit.domain.ReplyVO;
import com.dgit.domain.SectionVO;
import com.dgit.domain.TypeInfo;
import com.dgit.domain.UserVO;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	private static final String NAMESPACE = "com.dgit.persistence.ReplyDao";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(ReplyVO reply) throws Exception {
		sqlSession.insert(NAMESPACE + ".insert", reply);
		
	}

	@Override
	public void delete(ReplyVO reply) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", reply);
		
	}

	@Override
	public void update(ReplyVO reply) throws Exception {
		sqlSession.update(NAMESPACE + ".update", reply);
		
	}

	@Override
	public List<ReplyVO> selectAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectAll");
	}

	@Override
	public List<ReplyVO> selectReplyByBoardNum(int num, Criteria cri) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		map.put("num", num);
		map.put("cri", cri);
		
		return sqlSession.selectList(NAMESPACE + ".selectReplyByBoardNum", map);
	}

	@Override
	public int selectReplyCount(int boardNum) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".selectReplyCount", boardNum);
	}

	
}
