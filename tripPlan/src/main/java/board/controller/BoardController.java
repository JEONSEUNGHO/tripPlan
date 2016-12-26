package board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardDAO;
import board.model.BoardDTO;

@Controller
public class BoardController {
	
	@Autowired
	BoardDAO dao;
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	
	//경로생성 클릭 후 첫 페이지
	@RequestMapping(value="/createBoard.do", method=RequestMethod.GET)
	public String createBoardForm(){
		return "createBoard";
	}
	
	//경로 생성 클릭 후 mainBoard 작성 후 다음 클릭 시
	@RequestMapping(value="/createBoard.do", method=RequestMethod.POST)
	public ModelAndView submitMainBoard(){ 								//jsp에서 값 받아와야함
		ModelAndView mav = new ModelAndView("createBoard");
		BoardDTO board = new BoardDTO();								//값 받아와서 생성자에 넣어줘야함
		int check;
		check = dao.insertMainBoard(board);
		mav.addObject("check", check);
		return mav;
	}
	//mainBoard에서 다음 버튼 클릭 후 화면
	@RequestMapping(value="createSubBoard.do", method=RequestMethod.GET)
	public String createSubBoardForm(){
		return "createSubBoard";
	}
	
	//subBoard에서 완료 버튼 클릭 시
	@RequestMapping(value="createSubBoard.do", method=RequestMethod.POST)	//수정 필요
	public ModelAndView submitSubBoard(){
		ModelAndView mav = new ModelAndView("createSubBoard");
		
		return mav;
	}
	//각 게시판 별 mainBoardList 조회
	@RequestMapping(value="/reviewBoard.do", method=RequestMethod.GET)
	public ModelAndView selectAllMainBoard(int identified){
		ModelAndView mav = new ModelAndView("reviewBoard");
		List<BoardDTO> mainBoardList = new ArrayList<>();
		mainBoardList = dao.mainBoardAll(identified);
		mav.addObject("mainBoardList", mainBoardList);
		return mav;
	}
}
