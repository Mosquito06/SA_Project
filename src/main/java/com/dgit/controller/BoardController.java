package com.dgit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgit.domain.SectionVO;
import com.dgit.domain.TypeInfo;
import com.dgit.service.SectionService;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private SectionService sectionService;
	
	@RequestMapping(value="/board", method = RequestMethod.GET)
	public String goBoard(int serctionNum, Model model){
		
		try {
			TypeInfo typeInfo = sectionService.getTypeNum(serctionNum);
			List<SectionVO> section = sectionService.selectByDivisionNum(typeInfo.getDivisionNum());
			
			model.addAttribute("typeInfo", typeInfo);
			model.addAttribute("section", section);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
		return "board/board";
	}
}
