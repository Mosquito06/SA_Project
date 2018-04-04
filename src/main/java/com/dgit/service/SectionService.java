package com.dgit.service;

import java.util.List;

import com.dgit.domain.SectionVO;

public interface SectionService {
	public void insertSection(SectionVO category) throws Exception;
	public void updateSection(SectionVO category) throws Exception;
	public void deleteSection(SectionVO category) throws Exception;
	public List<SectionVO> selectByDivisionNum(int num) throws Exception;
	public List<SectionVO> selectAll() throws Exception; 
	
}
