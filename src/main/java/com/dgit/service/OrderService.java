package com.dgit.service;

import java.util.List;

import com.dgit.domain.OrderVO;

public interface OrderService {
	public void insert(OrderVO order) throws Exception;
	public void delete(OrderVO order) throws Exception;
	public void update(OrderVO order) throws Exception;
	public List<OrderVO> selectOrderByClientNum(int num) throws Exception;
	public List<OrderVO> selectOrderByBoardNum(int num) throws Exception;
}
