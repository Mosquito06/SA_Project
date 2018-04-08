package com.dgit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.UserVO;
import com.dgit.persistence.UserDao;

@Repository
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;
	
	@Override
	public void insertUser(UserVO user) throws Exception {
		dao.insertUser(user);

	}

	@Override
	public void updateUser(UserVO user) throws Exception {
		dao.updateUser(user);

	}

	@Override
	public void deleteUser(UserVO user) throws Exception {
		dao.deleteUser(user);

	}

	@Override
	public UserVO selectUserByIdAndPw(UserVO user) throws Exception {
		return dao.selectUserByIdAndPw(user);
	}

	@Override
	public UserVO selectUserById(String id) throws Exception {
		return dao.selectUserById(id);
	}

}
