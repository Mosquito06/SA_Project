package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.AddFileVO;

public interface AddFileDao {
	public void insert(AddFileVO addFile) throws Exception;
	public void delete(AddFileVO addFile) throws Exception;
	public void update(AddFileVO addFile) throws Exception;
	public List<AddFileVO> selectAll() throws Exception;
	public List<AddFileVO> selectAddFileByBoardNum(int num) throws Exception;
}
