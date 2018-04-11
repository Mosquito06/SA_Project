package com.dgit.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgit.domain.BoardVO;
import com.dgit.domain.Criteria;
import com.dgit.domain.PageMaker;
import com.dgit.domain.ReplyVO;
import com.dgit.domain.SearchCriteria;
import com.dgit.domain.UserVO;
import com.dgit.service.ReplyService;

@Controller
public class ReplyController {
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Autowired
	private ReplyService replyService;
	
	@ResponseBody
	@RequestMapping(value="/read/{boardNum}/{page}", method = RequestMethod.GET)
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
	
	@RequestMapping(value="/addReview", method = RequestMethod.GET)
	public String addPage(@ModelAttribute("sectionNum") int sectionNum, @ModelAttribute("cri") SearchCriteria cri, 
			@ModelAttribute("boardNum") int boardNum){
		
		return "board/addReview";
	}
	
	@RequestMapping(value="/addReview", method = RequestMethod.POST)
	public String addReview(@ModelAttribute("sectionNum") int sectionNum, @ModelAttribute("cri") SearchCriteria cri, 
			@ModelAttribute("boardNum") int boardNum, HttpServletRequest req, String replyTitle, String replyContent){
		UserVO user = (UserVO) req.getSession().getAttribute("login");
		
		BoardVO board = new BoardVO();
		board.setBoardNum(boardNum);
		
		ReplyVO reply = new ReplyVO();
		reply.setReplyContent(replyContent);
		reply.setReplyTitle(replyTitle);
		reply.setReplyWriter(user.getName());
		reply.setBoardNum(board);
				
		try {
			replyService.insertReply(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return "redirect: read";
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteReview/{replyNum}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delReview(@PathVariable("replyNum") int replyNum){
		ResponseEntity<String> entity = null;
		
		ReplyVO reply = new ReplyVO();
		reply.setReplyNum(replyNum);
		
		try {
			replyService.deleteReply(reply);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
			
		return entity;
	}
	
	@RequestMapping(value="/updateReview", method = RequestMethod.GET)
	public String updatePage(@ModelAttribute("sectionNum") int sectionNum, @ModelAttribute("cri") SearchCriteria cri, 
			@ModelAttribute("boardNum") int boardNum, @ModelAttribute("replyNum") int replyNum, Model model){
		
		try {
			ReplyVO reply = replyService.selectReplyByReplyNum(replyNum);
			model.addAttribute("reply", reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return "board/updateReview";
	}
	
	@RequestMapping(value="/updateReview", method = RequestMethod.POST)
	public String updateReview(@ModelAttribute("sectionNum") int sectionNum, @ModelAttribute("cri") SearchCriteria cri, 
			@ModelAttribute("boardNum") int boardNum, HttpServletRequest req, int replyNum, String replyTitle, String replyContent){
		
		
		try {
			ReplyVO reply = replyService.selectReplyByReplyNum(replyNum);
			reply.setReplyContent(replyContent);
			reply.setReplyTitle(replyTitle);
			reply.setReplyTime(new Date());
			replyService.updateReply(reply);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		return "redirect: read";
	}
}
