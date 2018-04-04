package com.dgit.service;

import java.util.List;

import com.dgit.domain.DivisionVO;

public interface DivisionService {
	public void insertDivision(DivisionVO division) throws Exception;
	public void updateDivision(DivisionVO division) throws Exception;
	public void deleteDivision(DivisionVO division) throws Exception;
	public List<DivisionVO> selectByCategoryNum(int num) throws Exception;
	public List<DivisionVO> selectAll() throws Exception; 
	
}
