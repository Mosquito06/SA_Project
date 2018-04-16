package com.dgit.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.dgit.domain.AddFileVO;
import com.dgit.domain.BoardVO;
import com.dgit.domain.CreateBoard;
import com.dgit.domain.Criteria;
import com.dgit.domain.UpdateBoard;
import com.dgit.persistence.AddFileDao;
import com.dgit.persistence.BoardContentDao;
import com.dgit.persistence.BoardDao;
import com.dgit.persistence.UserDao;
import com.dgit.util.UploadFileUtils;

@Repository
public class BoardServiceImpl implements BoardService {
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	private final String UploadPath = "resources/upload";
	
	
	@Autowired
	private BoardDao dao;
	
	@Autowired
	private AddFileDao addFileDao;
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private BoardContentDao boardContentDao;
	
	@Override
	@Transactional
	public void insertBoard(CreateBoard createBoard) throws Exception {
		userDao.updateUser(createBoard.getUser());
		
		createBoard.getBoard().setClientNum(createBoard.getUser());
				
		dao.insert(createBoard.getBoard());
		
		createBoard.getBoardContent().setBoardNum(createBoard.getBoard());
		
		boardContentDao.insert(createBoard.getBoardContent()); 
		
		// 삭제 목록에 있는 파일을 다시 올렸을 경우 문제가 발생함
		// 오류 수정 필요(수정도 동일한 문제)
		
		if(!createBoard.getImgFiles().get(0).isEmpty()){
			/*logger.info("저장하려는 파일이 존재함");*/
			String uploadPath = createBoard.getRealPath() + "/" + UploadPath;
			
			for(MultipartFile f: createBoard.getImgFiles()){
				String savePath = UploadFileUtils.uploadFile(uploadPath, createBoard.getUser().getId(), f.getOriginalFilename(), f.getBytes());
				/*logger.info("savePath : " + savePath);*/
				AddFileVO addFile = new AddFileVO();
				addFile.setFilePath(savePath);
				addFile.setBoardNum(createBoard.getBoard());
				addFile.setRegDate(new Date());
				
				addFileDao.insert(addFile);
			}

		}

	}

	@Override
	@Transactional
	public void deleteBoard(BoardVO board, String rootPath) throws Exception {
		List<AddFileVO> files = addFileDao.selectAddFileByBoardNum(board.getBoardNum());
		
		if(!files.isEmpty()){
			for(AddFileVO f : files){
				UploadFileUtils.deleteImg(rootPath + UploadPath + f.getFilePath());
			}
		}
				
		dao.delete(board);
		
	}

	@Override
	@Transactional
	public void updateBoard(UpdateBoard updateBoard) throws Exception {
		logger.info("update Service 진입?");
		
		// 밑의 수정 알고리즘이 상당히 느림
		// 개선 필요
		
		updateBoard.getBoard().setBoardUpdate(new Date());
		dao.update(updateBoard.getBoard());
		
		boardContentDao.update(updateBoard.getBoardContent());
		
		if(!updateBoard.getImgFiles().get(0).isEmpty()){
			String uploadPath = updateBoard.getRealPath() + "/" + UploadPath;
			
			for(MultipartFile f: updateBoard.getImgFiles()){
				String savePath = UploadFileUtils.uploadFile(uploadPath, updateBoard.getUser().getId(), f.getOriginalFilename(), f.getBytes());
				/*logger.info("savePath : " + savePath);*/
				AddFileVO addFile = new AddFileVO();
				addFile.setFilePath(savePath);
				addFile.setBoardNum(updateBoard.getBoard());
				addFile.setRegDate(new Date());
				
				addFileDao.insert(addFile);
			}
		}
		
		if(updateBoard.getUpdateDelFiles().length > 0){
			for(String s : updateBoard.getUpdateDelFiles()){
				if(s != null){
					System.out.println("startsWith('/') : " + s.startsWith("/"));
					
					if(s.startsWith("/")){
						UploadFileUtils.deleteImg(updateBoard.getRealPath() + UploadPath + s.toString());
						
						AddFileVO addFile = new AddFileVO();
						addFile.setFilePath(s.toString());
											
						addFileDao.delete(addFile);
					}
				}
			}
		}
		
		
	}

	@Override
	public List<BoardVO> selectAll() throws Exception {
		return dao.selectAll();
	}

	@Override
	@Transactional
	public BoardVO selectBoardByBoardNum(int num, boolean readCheck) throws Exception {
		if(readCheck){
			dao.updateReadCount(num);
		}		
		
		BoardVO board = dao.selectBoardByBoardNum(num);
		
		List<AddFileVO> files = addFileDao.selectAddFileByBoardNum(board.getBoardNum());
		if(!files.isEmpty()){
			board.setFiles(files); 
		}
		
		return board;
	}

	@Override
	@Transactional
	public List<BoardVO> selectBoardBySectionNum(int num, Criteria cri) throws Exception {
		
		List<BoardVO> boards = dao.selectBoardBySectionNum(num, cri);
		for(BoardVO b : boards){
			List<AddFileVO> files = addFileDao.selectAddFileByBoardNum(b.getBoardNum());
			/*System.out.println(files.isEmpty());*/
			if(!files.isEmpty()){
				/*System.out.println("가져오려는 파일이 존재함");*/
				b.setFiles(files); 
			}
		}
		
		return boards;
	}

	@Override
	public int selectBoardCount(int num) throws Exception {
		return dao.selectBoardCount(num);
	}

	@Override
	public List<BoardVO> selectBoardByClientNum(int num) throws Exception {
		
		List<BoardVO> boards = dao.selectBoardByClientNum(num);
		
		for(BoardVO b : boards){
			List<AddFileVO> files = addFileDao.selectAddFileByBoardNum(b.getBoardNum());
			
			if(!files.isEmpty()){
				b.setFiles(files); 
			}
		}
		
		return boards;
	}

	

	
}
