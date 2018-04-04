package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.CategoryVO;
import com.dgit.domain.DivisionVO;
import com.dgit.domain.SectionVO;

public interface DivisionDao {
	public void insert(DivisionVO division) throws Exception;
	public void update(DivisionVO division) throws Exception;
	public void delete(DivisionVO division) throws Exception;
	public List<DivisionVO> selectByCategoryNum(int num) throws Exception;
	public List<DivisionVO> selectAll() throws Exception; 
	
}
