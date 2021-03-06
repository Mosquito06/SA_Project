package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.Criteria;
import com.dgit.domain.OrderStatus;
import com.dgit.domain.OrderVO;

public interface OrderDao {
	public void insert(OrderVO order) throws Exception;
	public void delete(OrderVO order) throws Exception;
	public void update(OrderVO order) throws Exception;
	public void updateOrderStatus(OrderVO order) throws Exception;
	public List<OrderVO> selectOrderByClientNum(int num, Criteria cri) throws Exception;
	public List<OrderVO> selectOrderByBoardNum(int num) throws Exception;
	public List<OrderVO> selectOrderByBoardNumAndStatus(int num, OrderStatus status) throws Exception;
	public List<OrderVO> selectAllOrderByWriterClientNum(int num) throws Exception;
	public List<OrderVO> selectAllOrderByWriterClientNumAndStatus(int num, OrderStatus status) throws Exception;
	public List<OrderVO> selectOrderSumGroupByBoardNum(int num) throws Exception;
	public int selectOrderTotal(int num) throws Exception;
}
