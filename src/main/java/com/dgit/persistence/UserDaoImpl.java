package com.dgit.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.UserVO;

@Repository
public class UserDaoImpl implements UserDao {
	private static final String NAMESPACE = "com.dgit.persistence.UserDao";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertUser(UserVO user) throws Exception {
		sqlSession.insert(NAMESPACE + ".insertUser", user);

	}

	@Override
	public void updateUser(UserVO user) throws Exception {
		sqlSession.update(NAMESPACE + ".updateUser", user);

	}

	@Override
	public void deleteUser(UserVO user) throws Exception {
		sqlSession.delete(NAMESPACE + ".deleteUser", user);

	}

	@Override
	public UserVO selectUserByIdAndPw(UserVO user) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".selectUserByIdAndPw", user);
	}

}
