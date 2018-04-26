package com.dgit.persistence;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.OrderStatus;
import com.dgit.domain.OrderVO;

@Repository
public class OrderDaoImpl implements OrderDao {
private static final String NAMESPACE = "com.dgit.persistence.OrderDao";
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public void insert(OrderVO order) throws Exception {
		sqlSession.insert(NAMESPACE + ".insert", order);

	}

	@Override
	public void delete(OrderVO order) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", order);

	}

	@Override
	public void update(OrderVO order) throws Exception {
		sqlSession.update(NAMESPACE + ".update", order);

	}
	
	@Override
	public void updateOrderStatus(OrderVO order) throws Exception {
		sqlSession.update(NAMESPACE + ".updateOrderStatus", order);
		
	}

	@Override
	public List<OrderVO> selectOrderByClientNum(int num) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectOrderByClientNum" , num); 
	}

	@Override
	public List<OrderVO> selectOrderByBoardNum(int num) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectOrderByBoardNum" , num);
	}

	@Override
	public List<OrderVO> selectAllOrderByWriterClientNum(int num) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectAllOrderByWriterClientNum" , num);
	}

	@Override
	public List<OrderVO> selectOrderByBoardNumAndStatus(int num, OrderStatus status) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		map.put("num", num);
		map.put("status", status);
		
		return sqlSession.selectList(NAMESPACE + ".selectOrderByBoardNumAndStatus" , map);
	}

	@Override
	public List<OrderVO> selectAllOrderByWriterClientNumAndStatus(int num, OrderStatus status) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		map.put("num", num);
		map.put("status", status);
		
		return sqlSession.selectList(NAMESPACE + ".selectAllOrderByWriterClientNumAndStatus" , map);
	}

	@Override
	public List<OrderVO> selectOrderSumGroupByBoardNum(int num) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectOrderSumGroupByBoardNum" , num);
	}

}
