package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.AddFileVO;
import com.dgit.persistence.AddFileDao;

@Repository
public class AddFileServiceImpl implements AddFileService {
	
	@Autowired
	private AddFileDao dao;

	@Override
	public void insertAddFile(AddFileVO addFile) throws Exception {
		dao.insert(addFile);
		
	}

	@Override
	public void deleteAddFile(AddFileVO addFile) throws Exception {
		dao.delete(addFile);
		
	}

	@Override
	public void updateAddFile(AddFileVO addFile) throws Exception {
		dao.update(addFile);
		
	}

	@Override
	public List<AddFileVO> selectAll() throws Exception {
		return dao.selectAll();
	}

	@Override
	public List<AddFileVO> selectAddFileByBoardNum(int num) throws Exception {
		return dao.selectAddFileByBoardNum(num);
	}

	
}
