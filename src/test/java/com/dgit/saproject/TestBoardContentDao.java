package com.dgit.saproject;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dgit.domain.BoardContentVO;
import com.dgit.domain.BoardVO;
import com.dgit.persistence.BoardContentDao;
import com.dgit.persistence.BoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class TestBoardContentDao {
	
	@Autowired
	private BoardContentDao dao;
	
	/*@Autowired
	private BoardDao dao;*/
	
	
	/*@Test
	public void testSelectAll(){
		try {
			List<BoardVO> board = dao.selectAll();
			for(BoardVO b : board){
				System.out.println(b.toString());
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
	
	@Test
	public void testSelectAll(){
		try {
			List<BoardContentVO> board = dao.selectAll();
			for(BoardContentVO b : board){
				System.out.println(b.toString());
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
