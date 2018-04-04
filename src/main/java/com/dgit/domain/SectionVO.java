package com.dgit.domain;

public class SectionVO {
	private int sectionNum;
	private String sectionName;
	private DivisionVO division;

	public SectionVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSectionNum() {
		return sectionNum;
	}

	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public DivisionVO getDivision() {
		return division;
	}

	public void setDivision(DivisionVO division) {
		this.division = division;
	}

	@Override
	public String toString() {
		return "SectionVO [sectionNum=" + sectionNum + ", sectionName=" + sectionName + ", division=" + division + "]";
	}

}
