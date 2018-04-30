package com.dgit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgit.domain.BoardVO;
import com.dgit.domain.CategoryVO;
import com.dgit.domain.Criteria;
import com.dgit.domain.DivisionVO;
import com.dgit.domain.OrderVO;
import com.dgit.domain.PageMaker;
import com.dgit.domain.SectionVO;
import com.dgit.domain.UserVO;
import com.dgit.service.BoardService;
import com.dgit.service.CategoryService;
import com.dgit.service.DivisionService;
import com.dgit.service.OrderService;
import com.dgit.service.SectionService;

@Controller
public class MyPageController {
	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private DivisionService divisionService;
	
	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String goMyPage(HttpServletRequest req, Model model, Criteria cri){
		PageMaker pageMaker = new PageMaker();
		
		UserVO loginUser = (UserVO) req.getSession().getAttribute("login");
		cri.setPerPageNum(3);
		
		pageMaker.setCri(cri);
		
		try {
			
			List<CategoryVO> category = categoryService.selectAll(); 
			List<DivisionVO> division = divisionService.selectAll(); 
			List<SectionVO> section = sectionService.selectAll(); 
			
			model.addAttribute("category", category);
			model.addAttribute("division", division);
			model.addAttribute("section", section);
			
			List<OrderVO> orders = orderService.selectOrderByClientNum(loginUser.getClientNum(), cri);
			
			for(OrderVO o : orders){
				BoardVO board = boardService.selectBoardByBoardNum(o.getBoardNum().getBoardNum(), false);
				o.setBoardNum(board);
			}
					
			pageMaker.setTotalCount(orderService.selectOrderTotal(loginUser.getClientNum()));
			
			model.addAttribute("orders", orders);
			model.addAttribute("pageMaker", pageMaker);
	
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
		return "mypage/mypage";
	}
	
}
