package com.dgit.domain;

public class BoardContentVO {
	private BoardVO boardNum;
	private String boardContent;

	public BoardContentVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardVO getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(BoardVO boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	@Override
	public String toString() {
		return "BoardContent [boardNum=" + boardNum + ", boardContent=" + boardContent + "]";
	}

}
