package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.DivisionVO;

@Repository
public class DivisionDaoImpl implements DivisionDao {
	private static final String NAMESPACE = "com.dgit.persistence.DivisionDao";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(DivisionVO division) throws Exception {
		sqlSession.insert(NAMESPACE + ".insert", division);
		
	}

	@Override
	public void update(DivisionVO division) throws Exception {
		sqlSession.update(NAMESPACE + ".update", division);
		
	}

	@Override
	public void delete(DivisionVO division) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", division);
		
	}

	@Override
	public List<DivisionVO> selectByCategoryNum(int num) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectByCategoryNum", num);
	}

	@Override
	public List<DivisionVO> selectAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectAll");
	}

	
	
	

}
