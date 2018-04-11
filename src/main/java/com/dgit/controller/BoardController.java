package com.dgit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgit.domain.BoardContentVO;
import com.dgit.domain.BoardVO;
import com.dgit.domain.CategoryVO;
import com.dgit.domain.Criteria;
import com.dgit.domain.DivisionVO;
import com.dgit.domain.PageMaker;
import com.dgit.domain.ReplyVO;
import com.dgit.domain.SearchCriteria;
import com.dgit.domain.SectionVO;
import com.dgit.domain.TypeInfo;
import com.dgit.service.BoardContentService;
import com.dgit.service.BoardService;
import com.dgit.service.CategoryService;
import com.dgit.service.DivisionService;
import com.dgit.service.ReplyService;
import com.dgit.service.SectionService;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private DivisionService divisionService;
	
	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private BoardContentService boardContentService;
	
	@RequestMapping(value="/board", method = RequestMethod.GET)
	public String goBoard(@ModelAttribute("sectionNum") int sectionNum, @ModelAttribute("cri") SearchCriteria cri, Model model){
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		try {
			List<CategoryVO> category = categoryService.selectAll(); 
			List<DivisionVO> division = divisionService.selectAll(); 
			List<SectionVO> section = sectionService.selectAll(); 
			
			model.addAttribute("category", category);
			model.addAttribute("division", division);
			model.addAttribute("section", section);
			
			TypeInfo typeInfo = sectionService.getTypeInfo(sectionNum);
			List<SectionVO> leftSection = sectionService.selectByDivisionNum(typeInfo.getDivisionNum());
			List<BoardVO> boards = boardService.selectBoardBySectionNum(sectionNum, cri);
			pageMaker.setTotalCount(boardService.selectBoardCount(sectionNum));
			
			model.addAttribute("typeInfo", typeInfo);
			model.addAttribute("leftSection", leftSection);
			model.addAttribute("boards", boards);
			model.addAttribute("pageMaker", pageMaker);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "board/board";
	}
	
	@RequestMapping(value="read", method= RequestMethod.GET)
	public String read(@ModelAttribute("sectionNum") int sectionNum, @ModelAttribute("cri") SearchCriteria cri, 
			@ModelAttribute("boardNum") int boardNum, Model model){
		
		try{
			List<CategoryVO> category = categoryService.selectAll(); 
			List<DivisionVO> division = divisionService.selectAll(); 
			List<SectionVO> section = sectionService.selectAll(); 
			
			model.addAttribute("category", category);
			model.addAttribute("division", division);
			model.addAttribute("section", section);
			
			BoardVO board = boardService.selectBoardByBoardNum(boardNum);
			BoardContentVO boardContent = boardContentService.selectboardContentByBoardNum(boardNum);
			
			
			Criteria criteria = new Criteria();
			criteria.setPage(1);
			criteria.setPerPageNum(5);
			
			List<ReplyVO> reples = replyService.selectReplyByBoardNum(boardNum, criteria);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);
			pageMaker.setTotalCount(replyService.selectReplyCount(boardNum));
			
			model.addAttribute("board", board);
			model.addAttribute("reples", reples);
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("boardContent", boardContent); 
		}catch(Exception e){
			e.printStackTrace();
		}

		return "board/read";
	}
}
