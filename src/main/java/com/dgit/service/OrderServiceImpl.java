package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.OrderVO;
import com.dgit.persistence.OrderDao;

@Repository
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao dao;
	
	@Override
	public void insert(OrderVO order) throws Exception {
		dao.insert(order);

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

}
