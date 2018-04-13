package com.dgit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.dgit.domain.BoardContentVO;
import com.dgit.domain.BoardVO;
import com.dgit.domain.CategoryVO;
import com.dgit.domain.CreateBoard;
import com.dgit.domain.Criteria;
import com.dgit.domain.DivisionVO;
import com.dgit.domain.PageMaker;
import com.dgit.domain.SearchCriteria;
import com.dgit.domain.SectionVO;
import com.dgit.domain.TypeInfo;
import com.dgit.domain.UpdateBoard;
import com.dgit.domain.UserVO;
import com.dgit.service.BoardContentService;
import com.dgit.service.BoardService;
import com.dgit.service.CategoryService;
import com.dgit.service.DivisionService;
import com.dgit.service.ReplyService;
import com.dgit.service.SectionService;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private DivisionService divisionService;
	
	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private BoardContentService boardContentService;
	
	@RequestMapping(value="/board", method = RequestMethod.GET)
	public String goBoard(@ModelAttribute("sectionNum") int sectionNum, @ModelAttribute("cri") SearchCriteria cri, Model model){
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		try {
			List<CategoryVO> category = categoryService.selectAll(); 
			List<DivisionVO> division = divisionService.selectAll(); 
			List<SectionVO> section = sectionService.selectAll(); 
			
			model.addAttribute("category", category);
			model.addAttribute("division", division);
			model.addAttribute("section", section);
			
			TypeInfo typeInfo = sectionService.getTypeInfo(sectionNum);
			List<SectionVO> leftSection = sectionService.selectByDivisionNum(typeInfo.getDivisionNum());
			List<BoardVO> boards = boardService.selectBoardBySectionNum(sectionNum, cri);
			pageMaker.setTotalCount(boardService.selectBoardCount(sectionNum));
			
			model.addAttribute("typeInfo", typeInfo);
			model.addAttribute("leftSection", leftSection);
			model.addAttribute("boards", boards);
			model.addAttribute("pageMaker", pageMaker);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "board/board";
	}
	
	@RequestMapping(value="/read", method= RequestMethod.GET)
	public String read(@ModelAttribute("sectionNum") int sectionNum, @ModelAttribute("cri") SearchCriteria cri, 
			@ModelAttribute("boardNum") int boardNum, Model model){
		
		try{
			List<CategoryVO> category = categoryService.selectAll(); 
			List<DivisionVO> division = divisionService.selectAll(); 
			List<SectionVO> section = sectionService.selectAll(); 
			
			model.addAttribute("category", category);
			model.addAttribute("division", division);
			model.addAttribute("section", section);
			
			BoardVO board = boardService.selectBoardByBoardNum(boardNum);
			BoardContentVO boardContent = boardContentService.selectboardContentByBoardNum(boardNum);
			
			
			Criteria criteria = new Criteria();
			criteria.setPage(1);
			criteria.setPerPageNum(5);
						
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);
			pageMaker.setTotalCount(replyService.selectReplyCount(boardNum));
			
			model.addAttribute("board", board);
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("boardContent", boardContent); 
		}catch(Exception e){
			e.printStackTrace();
		}

		return "board/read";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addPage(@ModelAttribute("sectionNum") int sectionNum, Model model){
		
		try{
			List<CategoryVO> category = categoryService.selectAll(); 
			List<DivisionVO> division = divisionService.selectAll(); 
			List<SectionVO> section = sectionService.selectAll(); 
			
			model.addAttribute("category", category);
			model.addAttribute("division", division);
			model.addAttribute("section", section);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "board/add";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addBoard(int num, UserVO user, BoardVO board, BoardContentVO boardContent, 
			List<MultipartFile> ImgFiles, HttpServletRequest req, Model model){
		logger.info("add Post 진입?");

		UserVO loginUser = (UserVO) req.getSession().getAttribute("login");
		loginUser.setAddress(user.getAddress());
		/*System.out.println("loginUser : " + loginUser.getClientNum());*/
		
		SectionVO section = new SectionVO();
		section.setSectionNum(num);
		board.setSectionNum(section);
		
		String rootPath = req.getSession().getServletContext().getRealPath("/");
		CreateBoard createBoard = new CreateBoard(loginUser, board, boardContent, ImgFiles, rootPath);
		
		try{
			boardService.insertBoard(createBoard);
			model.addAttribute("sectionNum", num);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect: board";
	}
	
	@RequestMapping(value="/del", method = RequestMethod.GET)
	public String delBoard(@ModelAttribute("sectionNum") int sectionNum, int boardNum, HttpServletRequest req){
		logger.info("del 진입?");
		
		String rootPath = req.getSession().getServletContext().getRealPath("/");
		BoardVO board = new BoardVO();
		board.setBoardNum(boardNum);
				
		try {
			boardService.deleteBoard(board, rootPath);
		
		} catch (Exception e) {
			e.printStackTrace();
		
		}	
		
		return "redirect: board";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String updatePage(@ModelAttribute("sectionNum") int sectionNum, @ModelAttribute("boardNum") int boardNum, Model model){
		
		try{
			List<CategoryVO> category = categoryService.selectAll(); 
			List<DivisionVO> division = divisionService.selectAll(); 
			List<SectionVO> section = sectionService.selectAll(); 
			
			BoardVO board = boardService.selectBoardByBoardNum(boardNum);
			BoardContentVO boardContent = boardContentService.selectboardContentByBoardNum(boardNum);
			
			
			model.addAttribute("category", category);
			model.addAttribute("division", division);
			model.addAttribute("section", section);
			model.addAttribute("board", board);
			model.addAttribute("boardContent", boardContent);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "board/update";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String updateBoard(int sNum, int bNum, UserVO user, BoardVO board, BoardContentVO boardContent, 
			List<MultipartFile> ImgFiles, String[] updateDelFiles, HttpServletRequest req, Model model){
		logger.info("update Post 진입?");
		
		System.out.println("ImgFiles.get(0).isEmpty() : "  + ImgFiles.get(0).isEmpty());
		System.out.println("updateDelFiles : "  + updateDelFiles.length);
		
		UserVO loginUser = (UserVO) req.getSession().getAttribute("login");
		
		if(!ImgFiles.get(0).isEmpty() && updateDelFiles.length > 0){
			for(int i = ImgFiles.size() - 1; i >= 0; i--){
				System.out.println("ImgFiles.size() : " + ImgFiles.size());
				System.out.println("i : " + i);
				for(int ii = 0; ii < updateDelFiles.length; ii++){
					System.out.println("ii : " + ii);
					if(updateDelFiles[ii] != null){
						if(ImgFiles.get(i).getOriginalFilename().equals(updateDelFiles[ii].toString())){
							ImgFiles.remove(i);
							updateDelFiles[ii] = null;
							break;
						}
					}
				}
			}
		}
		
		board.setBoardNum(bNum);
		boardContent.setBoardNum(board);		 
		
		String rootPath = req.getSession().getServletContext().getRealPath("/");
		UpdateBoard updateBoard = new UpdateBoard(board, loginUser, boardContent, ImgFiles, updateDelFiles, rootPath);
		

		try{
			boardService.updateBoard(updateBoard);
			
			model.addAttribute("sectionNum", sNum);
			model.addAttribute("boardNum", bNum);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect: board";
	}
}
