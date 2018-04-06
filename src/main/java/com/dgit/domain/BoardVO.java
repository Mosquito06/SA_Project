package com.dgit.domain;

import java.util.Date;

public class BoardVO {
	private int boardNum;
	private String boardTitle;
	private Date boardDate;
	private Date boardUpdate;
	private int boardCount;
	private int boardTotalCount;
	private UserVO clientNum;
	private SectionVO sectionNum;

	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public Date getBoardUpdate() {
		return boardUpdate;
	}

	public void setBoardUpdate(Date boardUpdate) {
		this.boardUpdate = boardUpdate;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public int getBoardTotalCount() {
		return boardTotalCount;
	}

	public void setBoardTotalCount(int boardTotalCount) {
		this.boardTotalCount = boardTotalCount;
	}

	public UserVO getClientNum() {
		return clientNum;
	}

	public void setClientNum(UserVO clientNum) {
		this.clientNum = clientNum;
	}

	public SectionVO getSectionNum() {
		return sectionNum;
	}

	public void setSectionNum(SectionVO sectionNum) {
		this.sectionNum = sectionNum;
	}

	@Override
	public String toString() {
		return "BoardVO [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardDate=" + boardDate
				+ ", boardUpdate=" + boardUpdate + ", boardCount=" + boardCount + ", boardTotalCount=" + boardTotalCount
				+ ", clientNum=" + clientNum + ", sectionNum=" + sectionNum + "]";
	}

}
