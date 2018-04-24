package com.dgit.saproject;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dgit.domain.OrderStatus;
import com.dgit.domain.OrderVO;
import com.dgit.service.BoardService;
import com.dgit.service.CategoryService;
import com.dgit.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class TestCategoryService {
	
	@Autowired
	private CategoryService service;

	@Autowired
	private BoardService board;
	
	@Autowired
	private OrderService order;
	
	/*@Test
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
	}*/
	
	/*@Test
	public void testSelectAll(){
		try {
			MaxVO max = board.selectMaxTotalCount();
			System.out.println(max.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	@Test
	public void testSelectAll(){
		try {
			List<OrderVO> list = order.selectAllOrderByWriterClientNumAndStatus(2, OrderStatus.READY);
			for(OrderVO o : list){
				System.out.println(o.toString());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
