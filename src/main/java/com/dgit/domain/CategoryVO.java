package com.dgit.domain;

public class CategoryVO {
	private int categoryNum;
	private String categoryName;

	public CategoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryVO [categoryNum=" + categoryNum + ", categoryName=" + categoryName + "]";
	}

}
