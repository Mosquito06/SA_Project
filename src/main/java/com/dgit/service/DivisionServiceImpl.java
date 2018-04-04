package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.CategoryVO;
import com.dgit.domain.DivisionVO;
import com.dgit.domain.UserVO;
import com.dgit.persistence.CategoryDao;
import com.dgit.persistence.DivisionDao;
import com.dgit.persistence.UserDao;

@Repository
public class DivisionServiceImpl implements DivisionService {
	
	@Autowired
	private DivisionDao dao;

	@Override
	public void insertDivision(DivisionVO division) throws Exception {
		dao.insert(division);
		
	}

	@Override
	public void updateDivision(DivisionVO division) throws Exception {
		dao.update(division);
		
	}

	@Override
	public void deleteDivision(DivisionVO division) throws Exception {
		dao.delete(division);
		
	}

	@Override
	public List<DivisionVO> selectByCategoryNum(int num) throws Exception {
		return dao.selectByCategoryNum(num);
	}

	@Override
	public List<DivisionVO> selectAll() throws Exception {
		return dao.selectAll();
	}
}
