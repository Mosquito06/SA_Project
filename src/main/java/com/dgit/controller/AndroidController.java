package com.dgit.controller;

import java.util.ArrayList;
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

import com.dgit.domain.BoardVO;
import com.dgit.domain.DivisionVO;
import com.dgit.domain.OrderStatus;
import com.dgit.domain.OrderVO;
import com.dgit.domain.SectionVO;
import com.dgit.domain.UserVO;
import com.dgit.service.BoardService;
import com.dgit.service.DivisionService;
import com.dgit.service.OrderService;
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
	
	@Autowired
	private OrderService orderService;
	
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
	
	@RequestMapping(value="/menu/{clientNum}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getMenu(@PathVariable("clientNum") int clientNum){
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
	
	@RequestMapping(value="/board/{sectionNum}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getBoard(@PathVariable("sectionNum") int sectionNum){
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
	
	@RequestMapping(value="/order/{boardNum}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getOrder(@PathVariable("boardNum") int boardNum){
		logger.info("getOrder 함수 진입??");
		logger.info("boardNum?? " + boardNum);
		
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<>();
		
		try{
			
			List<OrderVO> orders = orderService.selectOrderByBoardNum(boardNum);
			map.put("orders", orders);
			
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			
		}catch(Exception e){
			map.put("result", e.getMessage());
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
				
		return entity;
	}
	
	@RequestMapping(value="/order/{boardNum}/{statusNum}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getOrderBystatusNum(@PathVariable("boardNum") int boardNum, 
			@PathVariable("statusNum") int statusNum){
		logger.info("getOrderBystatusNum 함수 진입??");
		logger.info("boardNum : " + boardNum + " statusNum : " + statusNum);	
		
		
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<>();
		
		try{
			List<OrderVO> orders = new ArrayList<>();
			
			switch(statusNum){
				case 0:
					orders = orderService.selectOrderByBoardNum(boardNum);
					break;
				case 1:
					orders = orderService.selectOrderByBoardNumAndStatus(boardNum, OrderStatus.READY);
					break;
				case 2:
					orders = orderService.selectOrderByBoardNumAndStatus(boardNum, OrderStatus.ING);
					break;
				case 3:
					orders = orderService.selectOrderByBoardNumAndStatus(boardNum, OrderStatus.COMPLETE);
					break;
				case 4:
					orders = orderService.selectOrderByBoardNumAndStatus(boardNum, OrderStatus.CANCEL);
					break;
			}
			
			map.put("orders", orders);
			
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			
		}catch(Exception e){
			map.put("result", e.getMessage());
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
				
		return entity;
	}
	
	@RequestMapping(value="/client/{clientNum}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getAllOrder(@PathVariable("clientNum") int clientNum){
		
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<>();
		
		try{
			List<OrderVO> orders = orderService.selectAllOrderByWriterClientNum(clientNum);
			map.put("orders", orders);
			
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			
		}catch(Exception e){
			map.put("result", e.getMessage());
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
				
		return entity;
	}
	
	@RequestMapping(value="/client/{clientNum}/{statusNum}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getAllOrderBystatusNum(@PathVariable("clientNum") int clientNum, 
			@PathVariable("statusNum") int statusNum){
		
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<>();
		
		try{
			List<OrderVO> orders = new ArrayList<>();
			
			switch(statusNum){
				case 0:
					orders = orderService.selectAllOrderByWriterClientNum(clientNum);
					break;
				case 1:
					orders = orderService.selectAllOrderByWriterClientNumAndStatus(clientNum, OrderStatus.READY);
					break;
				case 2:
					orders = orderService.selectAllOrderByWriterClientNumAndStatus(clientNum, OrderStatus.ING);
					break;
				case 3:
					orders = orderService.selectAllOrderByWriterClientNumAndStatus(clientNum, OrderStatus.COMPLETE);
					break;
				case 4:
					orders = orderService.selectAllOrderByWriterClientNumAndStatus(clientNum, OrderStatus.CANCEL);
					break;
			}
			
			map.put("orders", orders);
			
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			
		}catch(Exception e){
			map.put("result", e.getMessage());
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
				
		return entity;
	}
	
	@RequestMapping(value="/update/{orderNum}/{statusNum}/{checkNum}/{num}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> updateOrderStatus(@PathVariable("orderNum") int orderNum, 
			@PathVariable("statusNum") int statusNum, @PathVariable("checkNum") int checkNum, @PathVariable("num") int num){
				
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<>();
		
		try{
			List<OrderVO> orders = new ArrayList<>();
			OrderVO order;
			
			
			switch(statusNum){
				case 1:
					order = new OrderVO();
					order.setOrderNum(orderNum);
					order.setOrderStatus(OrderStatus.ING);
					orderService.updateOrderStatus(order);
					break;
				case 2:
					order = new OrderVO();
					order.setOrderNum(orderNum);
					order.setOrderStatus(OrderStatus.COMPLETE);
					orderService.updateOrderStatus(order);
					break;
			}
			
			switch(checkNum){
				case 0:
					orders = orderService.selectOrderByBoardNum(num);
					break;
				case 1:
					orders = orderService.selectAllOrderByWriterClientNum(num);
					break;
			}
			
			map.put("orders", orders);
			
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			
		}catch(Exception e){
			map.put("result", e.getMessage());
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
				
		return entity;
	}
	
	@RequestMapping(value="/static/{clientNum}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getStaticValue(@PathVariable("clientNum") int clientNum){
		logger.info("getStaticValue 함수 진입??");
		logger.info("clientNum : " + clientNum);	
		
		
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<>();
		
		try{
			List<OrderVO> orders = orderService.selectOrderSumGroupByBoardNum(clientNum);
			
			map.put("orders", orders);
			
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			
		}catch(Exception e){
			map.put("result", e.getMessage());
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
				
		return entity;
	}
	
}
