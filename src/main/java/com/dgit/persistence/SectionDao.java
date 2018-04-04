package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.CategoryVO;
import com.dgit.domain.SectionVO;

public interface SectionDao {
	public void insert(SectionVO category) throws Exception;
	public void update(SectionVO category) throws Exception;
	public void delete(SectionVO category) throws Exception;
	public List<SectionVO> selectByDivisionNum(int num) throws Exception;
	public List<SectionVO> selectAll() throws Exception; 
	
}
