package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.CategoryVO;
import com.dgit.domain.UserVO;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	private static final String NAMESPACE = "com.dgit.persistence.CategoryDao";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(CategoryVO category) throws Exception {
		sqlSession.insert(NAMESPACE + ".insert", category);
		
	}

	@Override
	public void update(CategoryVO category) throws Exception {
		sqlSession.update(NAMESPACE + ".update", category);
		
	}

	@Override
	public void delete(CategoryVO category) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", category);
		
	}

	@Override
	public List<CategoryVO> selectAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectAll");
	}
	
	

}
