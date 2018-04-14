package com.dgit.service;

import java.util.List;

import com.dgit.domain.AddFileVO;
import com.dgit.domain.BasketVO;

public interface BasketService {
	public void insert(BasketVO basket) throws Exception;
	public void delete(BasketVO basket) throws Exception;
	public void update(BasketVO basket) throws Exception;
	public List<BasketVO> selectBasketByClienNum(int num) throws Exception;
	
}
