package com.dgit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgit.domain.BasketVO;
import com.dgit.domain.BoardVO;
import com.dgit.domain.CategoryVO;
import com.dgit.domain.DivisionVO;
import com.dgit.domain.SectionVO;
import com.dgit.domain.UserVO;
import com.dgit.service.BasketService;
import com.dgit.service.BoardService;
import com.dgit.service.CategoryService;
import com.dgit.service.DivisionService;
import com.dgit.service.SectionService;

@Controller
public class BasketController {
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
	private BasketService basketService;
	
	@RequestMapping(value="/basket", method = RequestMethod.GET)
	public String goBasket(HttpServletRequest req, Model model){
		UserVO user = (UserVO) req.getSession().getAttribute("login");
		
		
		try {
			List<CategoryVO> category = categoryService.selectAll(); 
			List<DivisionVO> division = divisionService.selectAll(); 
			List<SectionVO> section = sectionService.selectAll(); 
			
			model.addAttribute("category", category);
			model.addAttribute("division", division);
			model.addAttribute("section", section);
			
			List<BasketVO> basketList = basketService.selectBasketByClienNum(user.getClientNum());
			if(basketList.size() > 0){
				for(BasketVO b : basketList){
					BoardVO board = boardService.selectBoardByBoardNum(b.getBoardNum().getBoardNum(), false);
					b.getBoardNum().setFiles(board.getFiles());
				}
				
				model.addAttribute("basketList", basketList);
				return "basket/basket";
			}
			

		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return "basket/emptyBasket";
	}
	
	@ResponseBody
	@RequestMapping(value="/basket/{boardNum}", method = RequestMethod.POST)
	public ResponseEntity<String> putBasket(@PathVariable int boardNum, 
			HttpServletRequest req, int orderAmount, int orderPrice){
		UserVO user = (UserVO) req.getSession().getAttribute("login");
		
		logger.info("basket 추가 rest api 진입");
		
		ResponseEntity<String> entity = null;
		
		try{
			List<BasketVO> basketList = basketService.selectBasketByClienNum(user.getClientNum());
			for(BasketVO b : basketList){
				if(b.getBoardNum().getBoardNum() == boardNum){
					return entity = new ResponseEntity<String>("exist", HttpStatus.OK); 
				}
			}
			
			BoardVO board = new BoardVO();
			board.setBoardNum(boardNum);
			
			BasketVO basket = new BasketVO();
			basket.setClientNum(user);
			basket.setBoardNum(board);
			basket.setOrderAmount(orderAmount);
			basket.setOrderPrice(orderPrice);
			
			basketService.insert(basket);
			
			List<BasketVO> afterInsertList = basketService.selectBasketByClienNum(user.getClientNum());
			req.getSession().setAttribute("basketCount", afterInsertList.size());
			
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		}catch(Exception e){
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/delBasket", method = RequestMethod.GET)
	public String delBasket(int basketNum, HttpServletRequest req){		
		logger.info("basket del 진입");
		UserVO user = (UserVO) req.getSession().getAttribute("login");
		
		BasketVO basket = new BasketVO();
		basket.setBasketNum(basketNum);
		
		try{
			basketService.delete(basket);
		
			List<BasketVO> basketList = basketService.selectBasketByClienNum(user.getClientNum());
			if(basketList.isEmpty()){
				req.getSession().removeAttribute("basketCount");
			}else{
				req.getSession().setAttribute("basketCount", basketList.size());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "redirect: basket";
	}
	
	@ResponseBody
	@RequestMapping(value="/basket/{basketNum}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateBasket(@PathVariable int basketNum, @RequestBody BasketVO basket){
		logger.info("basket update rest api 진입");

		ResponseEntity<String> entity = null;
		
		try{
			BasketVO basketVO = new BasketVO();
			basketVO.setBasketNum(basketNum);
			basketVO.setOrderAmount(basket.getOrderAmount());
			basketVO.setOrderPrice(basket.getOrderPrice());
			
			basketService.update(basketVO);
			
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		}catch(Exception e){
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}
