package com.dgit.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.BoardVO;
import com.dgit.domain.Criteria;
import com.dgit.domain.MaxVO;

@Repository
public class BoardDaoImple implements BoardDao {
	private static final String NAMESPACE = "com.dgit.persistence.BoardDao";
	
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(BoardVO board) throws Exception {
		sqlSession.insert(NAMESPACE + ".insert", board);

	}

	@Override
	public void delete(BoardVO board) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", board);

	}

	@Override
	public void update(BoardVO board) throws Exception {
		sqlSession.update(NAMESPACE + ".update", board);

	}

	@Override
	public List<BoardVO> selectAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectAll");
	}

	@Override
	public BoardVO selectBoardByBoardNum(int num) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".selectBoardByBoardNum", num);
	}

	@Override
	public List<BoardVO> selectBoardBySectionNum(int num, Criteria cri) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		map.put("num", num);
		map.put("cri", cri);
		
		return sqlSession.selectList(NAMESPACE + ".selectBoardBySectionNum", map);
	}

	@Override
	public int selectBoardCount(int num) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".selectBoardCount", num);
	}

	@Override
	public void updateReadCount(int num) throws Exception {
		sqlSession.update(NAMESPACE + ".updateReadCount", num);
		
	}

	@Override
	public void updateTotalCount(int num, int amount) throws Exception {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("boardNum", num);
		map.put("amount", amount);
		
		sqlSession.update(NAMESPACE + ".updateTotalCount", map);
		
	}

	@Override
	public List<BoardVO> selectBoardByClientNum(int num) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectBoardByClientNum", num);
	}

	@Override
	public MaxVO selectMaxTotalCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".selectMaxTotalCount");
	}

	@Override
	public List<BoardVO> selectBoardNoCriBySectionNum(int num) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectBoardNoCriBySectionNum", num);
	}

	

}
