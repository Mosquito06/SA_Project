package com.dgit.domain;

import java.util.Date;

public class ReplyVO {
	private int replyNum;
	private String replyTitle;
	private String replyContent;
	private Date replyTime;
	private String replyWriter;
	private BoardVO boardNum;

	public ReplyVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}

	public String getReplyTitle() {
		return replyTitle;
	}

	public void setReplyTitle(String replyTitle) {
		this.replyTitle = replyTitle;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public String getReplyWriter() {
		return replyWriter;
	}

	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}

	public BoardVO getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(BoardVO boardNum) {
		this.boardNum = boardNum;
	}

	@Override
	public String toString() {
		return "ReplyVO [replyNum=" + replyNum + ", replyTitle=" + replyTitle + ", replyContent=" + replyContent
				+ ", replyTime=" + replyTime + ", replyWriter=" + replyWriter + ", boardNum=" + boardNum + "]";
	}

}
