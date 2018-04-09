package com.dgit.domain;

import java.util.Date;
import java.util.List;

public class BoardVO {
	private int boardNum;
	private String boardTitle;
	private Date boardDate;
	private Date boardUpdate;
	private int boardCount;
	private int boardTotalCount;
	private int boardPrice;
	private UserVO clientNum;
	private SectionVO sectionNum;
	private List<AddFileVO> files;

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

	public List<AddFileVO> getFiles() {
		return files;
	}

	public void setFiles(List<AddFileVO> files) {
		this.files = files;
	}

	public int getBoardPrice() {
		return boardPrice;
	}

	public void setBoardPrice(int boardPrice) {
		this.boardPrice = boardPrice;
	}

	@Override
	public String toString() {
		return "BoardVO [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardDate=" + boardDate
				+ ", boardUpdate=" + boardUpdate + ", boardCount=" + boardCount + ", boardTotalCount=" + boardTotalCount
				+ ", boardPrice=" + boardPrice + ", clientNum=" + clientNum + ", sectionNum=" + sectionNum + ", files="
				+ files + "]";
	}

}
