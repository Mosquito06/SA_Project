package com.dgit.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("read")
public class ReplyController {
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@RequestMapping(value="/{}/{}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getReply(){
		ResponseEntity<Map<String, Object>> entity = null;
		
		try{
			
			
		}catch(Exception e){
			
		}
		
		
		
		return entity;
	}
	
	
}
