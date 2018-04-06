package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.AddFileVO;

@Repository
public class AddFileDaoImpl implements AddFileDao{
	
	private static final String NAMESPACE = "com.dgit.persistence.AddFileDao";
		
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(AddFileVO addFile) throws Exception {
		sqlSession.insert(NAMESPACE + ".insert", addFile);
		
	}

	@Override
	public void delete(AddFileVO addFile) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", addFile);
		
	}

	@Override
	public void update(AddFileVO addFile) throws Exception {
		sqlSession.update(NAMESPACE + ".update", addFile);
		
	}

	@Override
	public List<AddFileVO> selectAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectAll");
	}

	@Override
	public List<AddFileVO> selectAddFileByBoardNum(int num) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectAddFileByBoardNum", num);
	}

}
