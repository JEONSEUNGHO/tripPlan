package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardDAO;
import board.model.BoardDTO;

@Controller
@RequestMapping("/search")
public class SearchController {

	
	@Autowired
	BoardDAO dao = new BoardDAO();
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView submit(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("search");
		System.out.println(request.getParameter("keywordsearch"));
		String search = (String)request.getParameter("keywordsearch");
		List<BoardDTO> member = dao.searchBoard(search);
		mav.addObject("search",member);
		mav.addObject("searchList",member.size());
		
		System.out.println("검색 결과 :::"+member.size());
		return mav;
	}
}
