package com.dgit.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.dgit.domain.OrderStatus;
import com.dgit.domain.OrderVO;
import com.dgit.domain.UserVO;

public interface OrderService {
	public void insert(String[] orders, OrderVO order, UserVO loginUser, HttpSession session) throws Exception;
	public void delete(OrderVO order) throws Exception;
	public void update(OrderVO order) throws Exception;
	public List<OrderVO> selectOrderByClientNum(int num) throws Exception;
	public List<OrderVO> selectOrderByBoardNum(int num) throws Exception;
	public List<OrderVO> selectOrderByBoardNumAndStatus(int num, OrderStatus status) throws Exception;
	public List<OrderVO> selectAllOrderByWriterClientNum(int num) throws Exception;
	public List<OrderVO> selectAllOrderByWriterClientNumAndStatus(int num, OrderStatus status) throws Exception;
}
