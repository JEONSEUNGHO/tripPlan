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
	
	//��λ��� Ŭ�� �� ù ������
	@RequestMapping(value="/createBoard.do", method=RequestMethod.GET)
	public String createBoardForm(){
		return "createBoard";
	}
	
	//��� ���� Ŭ�� �� mainBoard �ۼ� �� ���� Ŭ�� ��
	@RequestMapping(value="/createBoard.do", method=RequestMethod.POST)
	public ModelAndView submitMainBoard(){ 								//jsp���� �� �޾ƿ;���
		ModelAndView mav = new ModelAndView("createBoard");
		BoardDTO board = new BoardDTO();								//�� �޾ƿͼ� �����ڿ� �־������
		int check;
		check = dao.insertMainBoard(board);
		mav.addObject("check", check);
		return mav;
	}
	//mainBoard���� ���� ��ư Ŭ�� �� ȭ��
	@RequestMapping(value="createSubBoard.do", method=RequestMethod.GET)
	public String createSubBoardForm(){
		return "createSubBoard";
	}
	
	//subBoard���� �Ϸ� ��ư Ŭ�� ��
	@RequestMapping(value="createSubBoard.do", method=RequestMethod.POST)	//���� �ʿ�
	public ModelAndView submitSubBoard(){
		ModelAndView mav = new ModelAndView("createSubBoard");
		
		return mav;
	}
	//�� �Խ��� �� mainBoardList ��ȸ
	@RequestMapping(value="/reviewBoard.do", method=RequestMethod.GET)
	public ModelAndView selectAllMainBoard(int identified){
		ModelAndView mav = new ModelAndView("reviewBoard");
		List<BoardDTO> mainBoardList = new ArrayList<>();
		mainBoardList = dao.mainBoardAll(identified);
		mav.addObject("mainBoardList", mainBoardList);
		return mav;
	}
}
