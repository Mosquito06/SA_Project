package com.dgit.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dgit.domain.UserVO;
import com.dgit.service.UserService;

@RestController
@RequestMapping("/android")
public class AndroidController {
	private static final Logger logger = LoggerFactory.getLogger(AndroidController.class);
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> checkAndroid(String id, String pw){
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<>();
		UserVO checkId  = null;
		
		try{
			checkId = userService.selectUserById(id); 
			
			if(checkId != null){
				UserVO user = new UserVO();
				user.setId(id);
				user.setPw(pw);
				
				UserVO checkUser = userService.selectUserByIdAndPw(user);
				if(checkUser != null){
					map.put("result", "correct");
					map.put("loginUser", checkUser);
					entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
				}else{
					map.put("result", "pw error");
					entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
				}
			}else{
				map.put("result", "not exist");
				entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", "error");
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	
}
