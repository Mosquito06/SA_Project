package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.BasketVO;

@Repository
public class BasketDaoImpl implements BasketDao {
		
	private static final String NAMESPACE = "com.dgit.persistence.BasketDao";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(BasketVO basket) throws Exception {
		sqlSession.insert(NAMESPACE + ".insert", basket);

	}

	@Override
	public void delete(BasketVO basket) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", basket);

	}

	@Override
	public void update(BasketVO basket) throws Exception {
		sqlSession.update(NAMESPACE + ".update", basket);

	}

	@Override
	public List<BasketVO> selectBasketByClienNum(int num) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectBasketByClienNum" , num);
	}
}
