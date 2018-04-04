package com.dgit.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgit.domain.Status;
import com.dgit.domain.UserVO;
import com.dgit.service.UserService;

@Controller
public class SignController {
	private static final Logger logger = LoggerFactory.getLogger(SignController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/sign", method = RequestMethod.GET)
	public String goSign(){
		
		return "sign/sign";
	}
	
	@RequestMapping(value="/complete", method = RequestMethod.GET)
	public String signComplete(){
		
		return "sign/complete";
	}
	
	@RequestMapping(value="/checkId", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> checkId(String id){
		ResponseEntity<String> entity = null;
		String checkId  = "";
		
		try{
			checkId = userService.selectUserById(id);
			
			if(checkId != null){
				entity = new ResponseEntity<String>("exist", HttpStatus.OK);
			}else{
				entity = new ResponseEntity<String>("not exist", HttpStatus.OK);
			}
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
		}

		return entity; 
	}
	
	
	@RequestMapping(value="/sign", method = RequestMethod.POST)	
	public String Sign(UserVO user, HttpServletRequest request){
		user.setEmail(user.getId());
		user.setStatus(Status.JOIN); 
		request.getSession().setAttribute("login", user);;
		
		try {
			userService.insertUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return "redirect: complete";
	}
}
