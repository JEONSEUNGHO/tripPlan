package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardDAO;

@Controller
public class SearchController {

	
	@Autowired
	BoardDAO dao = new BoardDAO();
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
/*
	@RequestMapping(value="/tiles/search", method=RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("search");
		String search = 
		
		return mav;
	}*/
}
