package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.CategoryVO;
import com.dgit.domain.UserVO;
import com.dgit.persistence.CategoryDao;
import com.dgit.persistence.UserDao;

@Repository
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao dao;

	@Override
	public void insertCategory(CategoryVO category) throws Exception {
		dao.insert(category);
		
	}

	@Override
	public void updateCategory(CategoryVO category) throws Exception {
		dao.update(category);
		
	}

	@Override
	public void deleteCategory(CategoryVO category) throws Exception {
		dao.delete(category);
		
	}

	@Override
	public List<CategoryVO> selectAll() throws Exception {
		return dao.selectAll();
	}
}
