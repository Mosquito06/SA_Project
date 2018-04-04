package com.dgit.service;

import com.dgit.domain.UserVO;

public interface UserService {
	public void insertUser(UserVO user) throws Exception;
	public void updateUser(UserVO user) throws Exception;
	public void deleteUser(UserVO user) throws Exception;
	public String selectUserById(String id) throws Exception; 
	public UserVO selectUserByIdAndPw(UserVO user) throws Exception; 
	
}
