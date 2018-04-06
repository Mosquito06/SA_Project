package com.dgit.domain;

public class TypeInfo {
	private int sectionNum;
	private int divisionNum;
	private String sectionName;
	private String divisionName;
	private String bannerFile;
	private String categoryName;

	public TypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSectionNum() {
		return sectionNum;
	}

	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBannerFile() {
		return bannerFile;
	}

	public void setBannerFile(String bannerFile) {
		this.bannerFile = bannerFile;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	@Override
	public String toString() {
		return "TypeInfo [sectionNum=" + sectionNum + ", divisionNum=" + divisionNum + ", sectionName=" + sectionName
				+ ", divisionName=" + divisionName + ", bannerFile=" + bannerFile + ", categoryName=" + categoryName
				+ "]";
	}

}
