package com.dgit.service;

import java.util.List;

import com.dgit.domain.AddFileVO;

public interface AddFileService {
	public void insertAddFile(AddFileVO addFile) throws Exception;
	public void deleteAddFile(AddFileVO addFile) throws Exception;
	public void updateAddFile(AddFileVO addFile) throws Exception;
	public List<AddFileVO> selectAll() throws Exception;
	public List<AddFileVO> selectAddFileByBoardNum(int num) throws Exception;
	
}
