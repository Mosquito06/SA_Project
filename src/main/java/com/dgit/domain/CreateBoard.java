package com.dgit.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CreateBoard {
	private UserVO user;
	private BoardVO board;
	private BoardContentVO boardContent;
	private List<MultipartFile> ImgFiles;
	private String realPath;

	public CreateBoard(UserVO user, BoardVO board, BoardContentVO boardContent, List<MultipartFile> imgFiles,
			String realPath) {
		super();
		this.user = user;
		this.board = board;
		this.boardContent = boardContent;
		ImgFiles = imgFiles;
		this.realPath = realPath;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public BoardVO getBoard() {
		return board;
	}

	public void setBoard(BoardVO board) {
		this.board = board;
	}

	public BoardContentVO getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(BoardContentVO boardContent) {
		this.boardContent = boardContent;
	}

	public List<MultipartFile> getImgFiles() {
		return ImgFiles;
	}

	public void setImgFiles(List<MultipartFile> imgFiles) {
		ImgFiles = imgFiles;
	}

	public String getRealPath() {
		return realPath;
	}

	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}

	@Override
	public String toString() {
		return "CreateBoard [user=" + user + ", board=" + board + ", boardContent=" + boardContent + ", ImgFiles="
				+ ImgFiles + ", realPath=" + realPath + "]";
	}

}
