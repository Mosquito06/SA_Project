package com.dgit.domain;

import java.util.Date;

public class UserVO {
	private int clientNum;
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;
	private String homeTel;
	private String address;
	private Date joinDate;
	private Status status;

	public UserVO() {
		super();
	}

	public int getClientNum() {
		return clientNum;
	}

	public void setClientNum(int clientNum) {
		this.clientNum = clientNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHomeTel() {
		return homeTel;
	}

	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserVO [clientNum=" + clientNum + ", id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", homeTel=" + homeTel + ", address=" + address + ", joinDate=" + joinDate
				+ ", status=" + status + "]";
	}

}
