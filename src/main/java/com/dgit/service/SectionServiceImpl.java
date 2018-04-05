package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.SectionVO;
import com.dgit.domain.TypeInfo;
import com.dgit.persistence.SectionDao;

@Repository
public class SectionServiceImpl implements SectionService {
	
	@Autowired
	private SectionDao dao;

	@Override
	public void insertSection(SectionVO category) throws Exception {
		dao.insert(category);
		
	}

	@Override
	public void updateSection(SectionVO category) throws Exception {
		dao.update(category);
		
	}

	@Override
	public void deleteSection(SectionVO category) throws Exception {
		dao.delete(category);
		
	}

	@Override
	public List<SectionVO> selectByDivisionNum(int num) throws Exception {
		return dao.selectByDivisionNum(num);
	}

	@Override
	public List<SectionVO> selectAll() throws Exception {
		return dao.selectAll();
	}

	@Override
	public TypeInfo getTypeNum(int num) throws Exception {
		return dao.getTypeNum(num);
	}
}
