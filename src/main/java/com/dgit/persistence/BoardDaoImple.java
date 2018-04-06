package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.BoardVO;

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
	public List<BoardVO> selectBoardBySectionNum(int num) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectBoardBySectionNum", num);
	}

}
