package board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class SearchController {

	
	@Autowired
	BoardDAO dao = new BoardDAO();
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	/**
	 * 헤더에서 검색 시
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/search",method=RequestMethod.GET)
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
	
	/**
	 * 경로 페이지에서 검색 시
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/searchboard",method=RequestMethod.POST)
	public ModelAndView submit1(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("searchboard");
		String option = (String)request.getParameter("boardsearch");
		String search1 = (String)request.getParameter("input");
		Map<String,String> abc = new HashMap<String,String>();
		abc.put("option", option);
		abc.put("search1",search1);
		
		List<BoardDTO> board = dao.searchzz(abc);
		
		mav.addObject("board",board);
		mav.addObject("boardList",board.size());
		return mav;
	}
}
