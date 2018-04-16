package com.dgit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgit.domain.BasketVO;
import com.dgit.domain.BoardVO;
import com.dgit.domain.CategoryVO;
import com.dgit.domain.DivisionVO;
import com.dgit.domain.OrderVO;
import com.dgit.domain.SectionVO;
import com.dgit.domain.UserVO;
import com.dgit.service.BasketService;
import com.dgit.service.BoardService;
import com.dgit.service.CategoryService;
import com.dgit.service.DivisionService;
import com.dgit.service.OrderService;
import com.dgit.service.SectionService;

@Controller
public class OrderController {
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
	
	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping(value="/order", method = RequestMethod.GET)
	public String goOrder(int boardNum, @ModelAttribute("amount")int amount,  Model model){
				
		try {
			List<CategoryVO> category = categoryService.selectAll(); 
			List<DivisionVO> division = divisionService.selectAll(); 
			List<SectionVO> section = sectionService.selectAll(); 
			
			model.addAttribute("category", category);
			model.addAttribute("division", division);
			model.addAttribute("section", section);
			
			BoardVO board = boardService.selectBoardByBoardNum(boardNum, false);
			model.addAttribute("board", board);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return "order/order";
	}
	
	@RequestMapping(value="/basketOrder", method = RequestMethod.GET)
	public String goBasketOrder(HttpServletRequest req, Model model){
		UserVO user = (UserVO) req.getSession().getAttribute("login");
		
		try {
			List<CategoryVO> category = categoryService.selectAll(); 
			List<DivisionVO> division = divisionService.selectAll(); 
			List<SectionVO> section = sectionService.selectAll(); 
			
			model.addAttribute("category", category);
			model.addAttribute("division", division);
			model.addAttribute("section", section);
			
			List<BasketVO> basketList = basketService.selectBasketByClienNum(user.getClientNum());
			for(BasketVO b : basketList){
				BoardVO board = boardService.selectBoardByBoardNum(b.getBoardNum().getBoardNum(), false);
				b.getBoardNum().setFiles(board.getFiles());
			}
			
			model.addAttribute("basketList", basketList);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return "order/order";
	}
	
	@RequestMapping(value="/order", method = RequestMethod.POST)
	public String fianlOrder(String[] orders, UserVO user, OrderVO order, HttpServletRequest req){
		// orders 게시판 번호 / 주문 수량/ 최종가격 순으로 데이터가  하나의 객체로 전달
		logger.info("최종 주문 함수 진입?");
		
		UserVO loginUser = (UserVO) req.getSession().getAttribute("login");
		loginUser.setId(user.getId());
		loginUser.setPhone(user.getPhone());
		
		try {
			List<BasketVO> basket = basketService.selectBasketByClienNum(loginUser.getClientNum());
			int[] insertBoardNum = new int[orders.length];
			
			for(int i = 0; i < orders.length; i++){
				String[] orderArray = orders[i].split("/");
				
				BoardVO board = new BoardVO();
				board.setBoardNum(Integer.parseInt(orderArray[0]));
				
				order.setOrderAmount(Integer.parseInt(orderArray[1]));
				order.setOrderPrice(Integer.parseInt(orderArray[2]));
				order.setClientNum(loginUser);
				order.setBoardNum(board);
				
				orderService.insert(order);
				insertBoardNum[i] = Integer.parseInt(orderArray[0]);				
			}
			
			for(int i = 0; i < insertBoardNum.length; i++){
				/*System.out.println("basket.size() : " + basket.size());
				System.out.println("i : " + i);*/
				if(basket.size() > 0){
					for(int ii = basket.size() - 1; ii >= 0 ; ii--){
						// System.out.println("insertBoardNum = " + insertBoardNum[i] + " : " + "basketBoardNum = " + basket.get(ii).getBoardNum().getBoardNum());
						if(insertBoardNum[i] == basket.get(ii).getBoardNum().getBoardNum()){
							basketService.delete(basket.get(ii));
							basket.remove(ii);
						}
					}
				}
			}
			
			if(basket.size() == 0){
				req.getSession().removeAttribute("basketCount");
			}else{
				req.getSession().setAttribute("basketCount", basket.size());
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return "redirect: orderComplete";
	}
	
	@RequestMapping(value="/orderComplete", method = RequestMethod.GET)
	public String Complete(Model model){
		try {
			List<CategoryVO> category = categoryService.selectAll(); 
			List<DivisionVO> division = divisionService.selectAll(); 
			List<SectionVO> section = sectionService.selectAll(); 
			
			model.addAttribute("category", category);
			model.addAttribute("division", division);
			model.addAttribute("section", section);
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return "order/orderComplete";
	}
	
	
}
