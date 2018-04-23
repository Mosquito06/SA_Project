package com.dgit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dgit.domain.BoardVO;
import com.dgit.domain.DivisionVO;
import com.dgit.domain.SectionVO;
import com.dgit.domain.UserVO;
import com.dgit.service.BoardService;
import com.dgit.service.DivisionService;
import com.dgit.service.SectionService;
import com.dgit.service.UserService;

@RestController
@RequestMapping("/android")
public class AndroidController {
	private static final Logger logger = LoggerFactory.getLogger(AndroidController.class);
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DivisionService divisionService;
	
	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private BoardService boardService;
	
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
	
	@RequestMapping(value="/menu", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getMenu(int clientNum){
		/*logger.info("menu 함수 진입??");
		logger.info("clientNum?? " + clientNum);*/
				
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<>();
		
		try{
			List<DivisionVO> division = divisionService.selectAll(); 
			List<SectionVO> section = sectionService.selectAll();
			List<BoardVO> board = boardService.selectBoardByClientNum(clientNum);
			
			map.put("division", division);
			map.put("section", section);
			map.put("board", board);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			
		}catch(Exception e){
			map.put("result", e.getMessage());
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
				
		return entity;
	}
	
	@RequestMapping(value="/board", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getBoard(int sectionNum){
		logger.info("board 함수 진입??");
		logger.info("sectionNum?? " + sectionNum);
		
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<>();
		
		try{

			List<BoardVO> board = boardService.selectBoardNoCriBySectionNum(sectionNum);

			map.put("board", board);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			
		}catch(Exception e){
			map.put("result", e.getMessage());
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
				
		return entity;
	}
	
}
