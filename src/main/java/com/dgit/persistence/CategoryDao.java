package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.CategoryVO;

public interface CategoryDao {
	public void insert(CategoryVO category) throws Exception;
	public void update(CategoryVO category) throws Exception;
	public void delete(CategoryVO category) throws Exception;
	public List<CategoryVO> selectAll() throws Exception; 
	
}
