package com.dgit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dgit.domain.Criteria;
import com.dgit.domain.PageMaker;
import com.dgit.domain.ReplyVO;
import com.dgit.service.ReplyService;

@RestController
@RequestMapping("read")
public class ReplyController {
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="/{boardNum}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getReply(@PathVariable("boardNum") int boardNum, @PathVariable int page){
		ResponseEntity<Map<String, Object>> entity = null;
		Criteria cri = new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(5);
		
		try{
			List<ReplyVO> reples = replyService.selectReplyByBoardNum(boardNum, cri);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(replyService.selectReplyCount(boardNum));
			
			HashMap<String, Object> map = new HashMap<>();
			map.put("reples", reples);
			map.put("pageMaker", pageMaker);
			
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			
		}catch(Exception e){
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
				
		return entity;
	}
	
	
}
