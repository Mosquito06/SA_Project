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
		
		if(!createBoard.getImgFiles().get(0).isEmpty()){
			logger.info("저장하려는 파일이 존재함");
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
	public void deleteBoard(BoardVO board) throws Exception {
		dao.delete(board);
		
	}

	@Override
	public void updateBoard(BoardVO board) throws Exception {
		dao.update(board);
		
	}

	@Override
	public List<BoardVO> selectAll() throws Exception {
		return dao.selectAll();
	}

	@Override
	@Transactional
	public BoardVO selectBoardByBoardNum(int num) throws Exception {
			
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

	

	
}
