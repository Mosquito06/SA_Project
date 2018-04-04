package com.dgit.saproject;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dgit.domain.CategoryVO;
import com.dgit.domain.DivisionVO;
import com.dgit.service.CategoryService;
import com.dgit.service.DivisionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class TestDivisionService {
	
	@Autowired
	private DivisionService service;
	
	//@Test
	public void testSelectAll(){
		try {
			List<DivisionVO> division = service.selectAll();
			for(DivisionVO d : division){
				System.out.println(d.toString());
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void selectByCategoryNum(){
		try {
			List<DivisionVO> division = service.selectByCategoryNum(2);
			for(DivisionVO d : division){
				System.out.println(d.toString());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
