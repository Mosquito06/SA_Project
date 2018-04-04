package com.dgit.domain;

public class DivisionVO {
	private int divisionNum;
	private String divisionName;
	private CategoryVO category;

	public DivisionVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDivisionNum() {
		return divisionNum;
	}

	public void setDivisionNum(int divisionNum) {
		this.divisionNum = divisionNum;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public CategoryVO getCategory() {
		return category;
	}

	public void setCategory(CategoryVO category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "DivisionVO [divisionNum=" + divisionNum + ", divisionName=" + divisionName + ", category=" + category
				+ "]";
	}

}
