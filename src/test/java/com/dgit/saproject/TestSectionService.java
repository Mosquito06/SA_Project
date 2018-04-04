package com.dgit.saproject;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dgit.domain.SectionVO;
import com.dgit.service.SectionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class TestSectionService {
	
	@Autowired
	private SectionService service;
	
	@Test
	public void testSelectAll(){
		try {
			List<SectionVO> section = service.selectAll();
			for(SectionVO d : section){
				System.out.println(d.toString());
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public void selectByCategoryNum(){
		try {
			List<SectionVO> section = service.selectByDivisionNum(2);
			for(SectionVO d : section){
				System.out.println(d.toString());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
