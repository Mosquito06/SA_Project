package com.dgit.domain;

import java.util.Date;

public class AddFileVO {
	private int fileNum;
	private String filePath;
	private Date regDate;
	private BoardVO boardNum;

	public AddFileVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFileNum() {
		return fileNum;
	}

	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public BoardVO getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(BoardVO boardNum) {
		this.boardNum = boardNum;
	}

	@Override
	public String toString() {
		return "AddFile [fileNum=" + fileNum + ", filePath=" + filePath + ", regDate=" + regDate + ", boardNum="
				+ boardNum + "]";
	}

}
