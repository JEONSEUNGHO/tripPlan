package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardDAO;
import board.model.BoardDTO;

@Controller
public class PathList {

	@Autowired
	BoardDAO dao = new BoardDAO();

	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("pathList")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("pathList");
		List<BoardDTO> member = dao.selectAllBoard();
		mav.addObject("member",member);
		mav.addObject("List",member.size());
		System.out.println("size:::"+member.size());
		return mav;
	}
}
