package com.dgit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgit.domain.CategoryVO;
import com.dgit.domain.DivisionVO;
import com.dgit.domain.SectionVO;
import com.dgit.service.CategoryService;
import com.dgit.service.DivisionService;
import com.dgit.service.SectionService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private DivisionService divisionService;
	
	@Autowired
	private SectionService sectionService;
	
	
	@RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
	public String goMain(Model model) {
		
		try {
			List<CategoryVO> category = categoryService.selectAll(); 
			List<DivisionVO> division = divisionService.selectAll(); 
			List<SectionVO> section = sectionService.selectAll(); 
			
			model.addAttribute("category", category);
			model.addAttribute("division", division);
			model.addAttribute("section", section);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "main/main";
	}
}
