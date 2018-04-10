package com.dgit.saproject;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dgit.domain.CategoryVO;
import com.dgit.domain.ReplyVO;
import com.dgit.service.CategoryService;
import com.dgit.service.ReplyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class TestCategoryService {
	
	@Autowired
	private CategoryService service;
	
	@Autowired
	private ReplyService replyService;
	
	//@Test
	public void testSelectAll(){
		try {
			List<CategoryVO> category = service.selectAll();
			for(CategoryVO c : category){
				System.out.println(c.toString());
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void textReply(){
		try {
			List<ReplyVO> reply = replyService.selectReplyByBoardNum(1);
			for(ReplyVO r : reply){
				System.out.println(r.toString());
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
