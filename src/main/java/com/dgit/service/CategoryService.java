package com.dgit.service;

import java.util.List;

import com.dgit.domain.CategoryVO;

public interface CategoryService {
	public void insertCategory(CategoryVO category) throws Exception;
	public void updateCategory(CategoryVO category) throws Exception;
	public void deleteCategory(CategoryVO category) throws Exception;
	public List<CategoryVO> selectAll() throws Exception; 
	
}
