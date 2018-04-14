package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.BasketVO;

public interface BasketDao {
	public void insert(BasketVO basket) throws Exception;
	public void delete(BasketVO basket) throws Exception;
	public void update(BasketVO basket) throws Exception;
	public List<BasketVO> selectBasketByClienNum(int num) throws Exception;
}
