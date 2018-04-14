package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.AddFileVO;
import com.dgit.domain.BasketVO;
import com.dgit.persistence.AddFileDao;
import com.dgit.persistence.BasketDao;

@Repository
public class BasketServiceImpl implements BasketService {
	
	@Autowired
	private BasketDao dao;

	@Override
	public void insert(BasketVO basket) throws Exception {
		dao.insert(basket);
		
	}

	@Override
	public void delete(BasketVO basket) throws Exception {
		dao.delete(basket);
		
	}

	@Override
	public void update(BasketVO basket) throws Exception {
		dao.update(basket);
		
	}

	@Override
	public List<BasketVO> selectBasketByClienNum(int num) throws Exception {
		return dao.selectBasketByClienNum(num);
	}
}
