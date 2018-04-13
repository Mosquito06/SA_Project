package com.dgit.domain;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UpdateBoard {
	private BoardVO board;
	private UserVO user;
	private BoardContentVO boardContent;
	private List<MultipartFile> ImgFiles;
	private String[] updateDelFiles;
	private String realPath;;

	public UpdateBoard(BoardVO board, UserVO user, BoardContentVO boardContent, List<MultipartFile> imgFiles,
			String[] updateDelFiles, String realPath) {
		super();
		this.board = board;
		this.user = user;
		this.boardContent = boardContent;
		ImgFiles = imgFiles;
		this.updateDelFiles = updateDelFiles;
		this.realPath = realPath;
	}

	public BoardVO getBoard() {
		return board;
	}

	public void setBoard(BoardVO board) {
		this.board = board;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
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

	public String[] getUpdateDelFiles() {
		return updateDelFiles;
	}

	public void setUpdateDelFiles(String[] updateDelFiles) {
		this.updateDelFiles = updateDelFiles;
	}

	public String getRealPath() {
		return realPath;
	}

	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}

	@Override
	public String toString() {
		return "UpdateBoard [board=" + board + ", user=" + user + ", boardContent=" + boardContent + ", ImgFiles="
				+ ImgFiles + ", updateDelFiles=" + Arrays.toString(updateDelFiles) + ", realPath=" + realPath + "]";
	}

}
