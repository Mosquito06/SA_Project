package com.dgit.domain;

import java.util.Date;

public class OrderVO {
	private int orderNum;
	private Date orderDate;
	private int orderAmount;
	private int orderPrice;
	private String orderRecipient;
	private String recipientPhone;
	private String recipientAddress;
	private OrderStatus orderStatus;
	private UserVO clientNum;
	private BoardVO boardNum;

	public OrderVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderRecipient() {
		return orderRecipient;
	}

	public void setOrderRecipient(String orderRecipient) {
		this.orderRecipient = orderRecipient;
	}

	public String getRecipientPhone() {
		return recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
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
		return "OrderVO [orderNum=" + orderNum + ", orderDate=" + orderDate + ", orderAmount=" + orderAmount
				+ ", orderPrice=" + orderPrice + ", orderRecipient=" + orderRecipient + ", recipientPhone="
				+ recipientPhone + ", recipientAddress=" + recipientAddress + ", orderStatus=" + orderStatus
				+ ", clientNum=" + clientNum + ", boardNum=" + boardNum + "]";
	}

}
