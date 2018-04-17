package com.dgit.controller;

import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgit.domain.CategoryVO;
import com.dgit.domain.DivisionVO;
import com.dgit.domain.SectionVO;
import com.dgit.domain.Status;
import com.dgit.domain.UserVO;
import com.dgit.service.CategoryService;
import com.dgit.service.DivisionService;
import com.dgit.service.SectionService;
import com.dgit.service.UserService;

@Controller
public class SignController {
	private static final Logger logger = LoggerFactory.getLogger(SignController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private DivisionService divisionService;
	
	@Autowired
	private SectionService sectionService;
		
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/sign", method = RequestMethod.GET)
	public String goSign(Model model){
		
		
		try{
			List<CategoryVO> category = categoryService.selectAll(); 
			List<DivisionVO> division = divisionService.selectAll(); 
			List<SectionVO> section = sectionService.selectAll(); 
			
			model.addAttribute("category", category);
			model.addAttribute("division", division);
			model.addAttribute("section", section);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return "sign/sign";
	}
	
	@RequestMapping(value="/complete", method = RequestMethod.GET)
	public String signComplete(Model model){
		
		try{
			List<CategoryVO> category = categoryService.selectAll(); 
			List<DivisionVO> division = divisionService.selectAll(); 
			List<SectionVO> section = sectionService.selectAll(); 
			
			model.addAttribute("category", category);
			model.addAttribute("division", division);
			model.addAttribute("section", section);
		}catch(Exception e){
			e.printStackTrace();
		}
				
		return "sign/complete";
	}
	
	@RequestMapping(value="/checkId", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> checkId(String id){
		ResponseEntity<String> entity = null;
		UserVO checkId  = null;
		
		try{
			checkId = userService.selectUserById(id);
			
			if(checkId != null){
				entity = new ResponseEntity<String>("exist", HttpStatus.OK);
			}else{
				entity = new ResponseEntity<String>("not exist", HttpStatus.OK);
			}
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity; 
	}
	
	
	@RequestMapping(value="/sign", method = RequestMethod.POST)	
	public String Sign(UserVO user, HttpServletRequest request){
		user.setEmail(user.getId());
		user.setStatus(Status.JOIN); 
		
		
		try {
			userService.insertUser(user);
			/*System.out.println("user = " + user.getClientNum());*/
			request.getSession().setAttribute("login", user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return "redirect:complete";
	}
}
