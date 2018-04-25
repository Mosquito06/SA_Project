package com.dgit.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dgit.domain.BasketVO;
import com.dgit.domain.BoardVO;
import com.dgit.domain.OrderStatus;
import com.dgit.domain.OrderVO;
import com.dgit.domain.UserVO;
import com.dgit.persistence.BasketDao;
import com.dgit.persistence.BoardDao;
import com.dgit.persistence.OrderDao;

@Repository
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao dao;
	
	@Autowired
	private BasketDao basketDao;
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	@Transactional
	public void insert(String[] orders, OrderVO order, UserVO loginUser, HttpSession session) throws Exception {
		
		List<BasketVO> basket = basketDao.selectBasketByClienNum(loginUser.getClientNum());
		int[] insertBoardNum = new int[orders.length];
			
		
		try {
			for(int i = 0; i < orders.length; i++){
				String[] orderArray = orders[i].split("/");
				
				BoardVO board = new BoardVO();
				board.setBoardNum(Integer.parseInt(orderArray[0]));
				
				order.setOrderAmount(Integer.parseInt(orderArray[1]));
				order.setOrderPrice(Integer.parseInt(orderArray[2]));
				order.setClientNum(loginUser);
				order.setBoardNum(board);
				order.setOrderStatus(OrderStatus.READY);
				
				dao.insert(order);
				boardDao.updateTotalCount(board.getBoardNum(), Integer.parseInt(orderArray[1]));
				
				insertBoardNum[i] = Integer.parseInt(orderArray[0]);				
			}
			
			for(int i = 0; i < insertBoardNum.length; i++){
				/*System.out.println("basket.size() : " + basket.size());
				System.out.println("i : " + i);*/
				if(basket.size() > 0){
					for(int ii = basket.size() - 1; ii >= 0 ; ii--){
						// System.out.println("insertBoardNum = " + insertBoardNum[i] + " : " + "basketBoardNum = " + basket.get(ii).getBoardNum().getBoardNum());
						if(insertBoardNum[i] == basket.get(ii).getBoardNum().getBoardNum()){
							basketDao.delete(basket.get(ii));
							basket.remove(ii);
						}
					}
				}
			}
			
			if(basket.size() == 0){
				session.removeAttribute("basketCount");
			}else{
				session.setAttribute("basketCount", basket.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(OrderVO order) throws Exception {
		dao.delete(order);

	}

	@Override
	public void update(OrderVO order) throws Exception {
		dao.update(order);

	}

	@Override
	public List<OrderVO> selectOrderByClientNum(int num) throws Exception {
		return dao.selectOrderByClientNum(num);
	}

	@Override
	public List<OrderVO> selectOrderByBoardNum(int num) throws Exception {
		return dao.selectOrderByBoardNum(num); 
	}

	@Override
	public List<OrderVO> selectAllOrderByWriterClientNum(int num) throws Exception {
		return dao.selectAllOrderByWriterClientNum(num);
	}

	@Override
	public List<OrderVO> selectOrderByBoardNumAndStatus(int num, OrderStatus status) throws Exception {
		return dao.selectOrderByBoardNumAndStatus(num, status);
	}

	@Override
	public List<OrderVO> selectAllOrderByWriterClientNumAndStatus(int num, OrderStatus status) throws Exception {
		return dao.selectAllOrderByWriterClientNumAndStatus(num, status);
	}

	@Override
	public void updateOrderStatus(OrderVO order) throws Exception {
		dao.updateOrderStatus(order);
		
	}

}
