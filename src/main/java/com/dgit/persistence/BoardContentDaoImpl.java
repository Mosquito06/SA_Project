package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.BoardContentVO;

@Repository
public class BoardContentDaoImpl implements BoardContentDao{
	private static final String NAMESPACE = "com.dgit.persistence.BoardContentDao";
	
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public void insert(BoardContentVO boardContent) throws Exception {
		sqlSession.insert(NAMESPACE + ".insert", boardContent);
		
	}

	@Override
	public void delete(BoardContentVO boardContent) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", boardContent);
		
	}

	@Override
	public void update(BoardContentVO boardContent) throws Exception {
		sqlSession.update(NAMESPACE + ".update", boardContent);
		
	}

	@Override
	public List<BoardContentVO> selectAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectAll");
	}

	@Override
	public BoardContentVO selectboardContentByBoardNum(int num) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".selectboardContentByBoardNum", num);
	}

}
