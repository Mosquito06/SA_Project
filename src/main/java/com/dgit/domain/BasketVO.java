package com.dgit.domain;

import java.util.Date;

public class BasketVO {
	private int basketNum;
	private Date orderDate;
	private int orderPrice;
	private int orderAmount;
	private UserVO clientNum;
	private BoardVO boardNum;

	public BasketVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBasketNum() {
		return basketNum;
	}

	public void setBasketNum(int basketNum) {
		this.basketNum = basketNum;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public UserVO getClientNum() {
		return clientNum;
	}

	public void setClientNum(UserVO clientNum) {
		this.clientNum = clientNum;
	}

	public BoardVO getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(BoardVO boardNum) {
		this.boardNum = boardNum;
	}

	@Override
	public String toString() {
		return "BasketVO [basketNum=" + basketNum + ", orderDate=" + orderDate + ", orderPrice=" + orderPrice
				+ ", orderAmount=" + orderAmount + ", clientNum=" + clientNum + ", boardNum=" + boardNum + "]";
	}

}
