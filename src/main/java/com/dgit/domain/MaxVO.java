package com.dgit.domain;

public class MaxVO {
	private int boardNum;
	private int sectionNum;

	public MaxVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public int getSectionNum() {
		return sectionNum;
	}

	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
	}

	@Override
	public String toString() {
		return "MaxVO [boardNum=" + boardNum + ", sectionNum=" + sectionNum + "]";
	}

}
