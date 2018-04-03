package com.dgit.persistence;

import com.dgit.domain.UserVO;

public interface UserDao {
	public void insertUser(UserVO user) throws Exception;
	public void updateUser(UserVO user) throws Exception;
	public void deleteUser(UserVO user) throws Exception;
	public UserVO selectUserByIdAndPw(UserVO user) throws Exception; 
	
}
