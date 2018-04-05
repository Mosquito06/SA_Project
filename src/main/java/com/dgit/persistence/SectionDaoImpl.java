package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.CategoryVO;
import com.dgit.domain.DivisionVO;
import com.dgit.domain.SectionVO;
import com.dgit.domain.TypeInfo;
import com.dgit.domain.UserVO;

@Repository
public class SectionDaoImpl implements SectionDao {
	private static final String NAMESPACE = "com.dgit.persistence.SectionDao";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(SectionVO category) throws Exception {
		sqlSession.insert(NAMESPACE + ".insert", category);
		
	}

	@Override
	public void update(SectionVO category) throws Exception {
		sqlSession.update(NAMESPACE + ".update", category);
		
	}

	@Override
	public void delete(SectionVO category) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", category);
		
	}

	@Override
	public List<SectionVO> selectByDivisionNum(int num) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectByDivisionNum", num);
	}

	@Override
	public List<SectionVO> selectAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectAll");
	}

	@Override
	public TypeInfo getTypeNum(int num) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getTypeNum", num);
	}

	

	
	
	

}
