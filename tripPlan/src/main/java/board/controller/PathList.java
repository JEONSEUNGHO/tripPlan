package board.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping("mainpath")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("pathList");
		List<BoardDTO> member = dao.selectAllBoard();
		mav.addObject("member",member);
		mav.addObject("List",member.size());
		System.out.println("size:::"+member.size());
		return mav;
	}
	@RequestMapping("reviewList.do")
	public ModelAndView reviewList(){
		ModelAndView mav = new ModelAndView("review");
		List<BoardDTO> review = dao.mainBoardAll(0);
		mav.addObject("review", review);
		return mav;
	}
	@RequestMapping("planList.do")
	public ModelAndView planList(){
		ModelAndView mav = new ModelAndView("plan");
		List<BoardDTO> plan = dao.mainBoardAll(1);
		mav.addObject("plan", plan);
		return mav;
	}
	@RequestMapping("groupList.do")
	public ModelAndView groupList(){
		ModelAndView mav = new ModelAndView("group");
		List<BoardDTO> group = dao.mainBoardAll(2);
		mav.addObject("group", group);
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/path", method = RequestMethod.GET)
	public void form1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<BoardDTO> board = dao.selectAllBoard();
		
		JSONArray boardArray = new JSONArray();
		for(int i=0;i<board.size();i++){
			JSONObject boardJson = new JSONObject();
			boardJson.put("b_id", board.get(i).getB_id());
			boardJson.put("b_title", board.get(i).getB_title());
			boardJson.put("b_maincontents", board.get(i).getB_maincontents());
			boardJson.put("b_mainphoto", board.get(i).getB_mainphoto());
			boardJson.put("b_registertime", board.get(i).getB_registertime());
			boardJson.put("bo_identified", board.get(i).getB_identified());
			boardJson.put("m_email", board.get(i).getM_email());
			boardArray.add(boardJson);
		}
			JSONObject jObject = new JSONObject();
			jObject.put("board", boardArray);
		/*JSONObject jso = new JSONObject(); // JASON 객체생성
		jso.put("data", board); // jason은 map구조(키,값), data라는 key로 list데이터를 주입했다.
*/
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		/*out.print(jso.toString());*/
		out.print(jObject.toString()); // out.print
									// 내용을
									// ajax의dataType이 jason에게데이터 쏴줌
		String str = boardArray.toString();
		String zzz = jObject.toString();
		System.out.println("jObject내용 ::: "+zzz);
		System.out.println(str);
		System.out.println("리스트 가져온거 :::"+board);
		
	}
	
}
