package com.dgit.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgit.domain.UserVO;
import com.dgit.service.UserService;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Inject
	private UserService userService;
	
	@RequestMapping(value="/loginCheck", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> checkId(@RequestBody UserVO user){
		ResponseEntity<String> entity = null;
		UserVO checkId  = null;

		try{
			checkId = userService.selectUserById(user.getId()); 
			
			if(checkId != null){
				UserVO checkUser = userService.selectUserByIdAndPw(user);
				if(checkUser != null){
					entity = new ResponseEntity<String>("correct", HttpStatus.OK);
				}else{
					entity = new ResponseEntity<String>("pw error", HttpStatus.OK);
				}
			}else{
				entity = new ResponseEntity<String>("not exist", HttpStatus.OK);
			}
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
		}

		return entity; 
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(UserVO user, String path, String query, Model model){
		String[] pathUpdate = path.split("/");
		String finalPath = pathUpdate[pathUpdate.length - 1].substring(0, pathUpdate[pathUpdate.length - 1].indexOf("."));
		logger.info("finalPath = " + finalPath);
		logger.info("query = " + query);
		
		try {
			UserVO loginUser = userService.selectUserByIdAndPw(user);
			
			model.addAttribute("login", loginUser);
			model.addAttribute("path", finalPath);
			
			if(query != null || query != ""){
				query = "?" + query;
				model.addAttribute("query", query);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "login/login";
	}
	
	@RequestMapping(value="/loginOut", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request){
		request.getSession().removeAttribute("login");
		String path = request.getContextPath() + "/";
		
		return "redirect: " + path;
	}

}
