package mypage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mypage.dao.CommentDAO;
import mypage.model.CommentDTO;

@Controller
public class CommentController {

	@Autowired
	private CommentDAO dao;
	
	public void setDao(CommentDAO dao) {
		this.dao = dao;
	}
	// 작성시간을 초까지만 표현해주는 method
	private SimpleDateFormat formatter;
	public String currentTime(){
	      formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	      return formatter.format(new Date());
	   }
	/*
	 * insert reply
	 */
	@RequestMapping(value = "/insertComment.do", method = RequestMethod.POST)
	public ModelAndView insertReply(HttpServletRequest request, String b_id, String re_contents) {
		ModelAndView mav = new ModelAndView("mypage");
		HttpSession session = request.getSession();
		
		int check = 0;
		// 세션 체크
		if (session.getAttribute("m_email") == null || session.getAttribute("m_email").equals("")) {
			System.out.println("Session_m_email is null");
			check = 0;
			mav.addObject("check", check);
			return new ModelAndView("isSessionCheck");
		}
		String m_email = (String) session.getAttribute("m_email");
		System.out.println("b_id: " + b_id);
		CommentDTO reply = new CommentDTO(re_contents, currentTime(), Integer.parseInt(b_id), m_email);
		System.out.println("reply: "+reply);
		check = dao.insertReply(reply);
		if (check == 0) {
			check = 0;
		} else {
			check = 1;
		}
		mav.addObject("b_id", b_id);
		mav.addObject("check", check);
		return mav;
	}

	/*
	 * delete reply
	 */
	@RequestMapping(value = "/deleteComment.do", method = RequestMethod.GET)
	public ModelAndView deleteReply(HttpServletRequest request, String re_id, String b_id) {
		ModelAndView mav = new ModelAndView("mypage");
		HttpSession session = request.getSession();
		int check = 0;
		// 세션 체크
		if (session.getAttribute("m_email") == null || session.getAttribute("m_email").equals("")) {
			System.out.println("Session_m_email is null");
			check = 0;
			mav.addObject("check", check);
			return new ModelAndView("isSessionCheck");
		}
		check = dao.deleteReply(Integer.parseInt(re_id));
		if (check == 0) {
			check = 0;
		} else {
			check = 2;
		}
		mav.addObject("b_id", Integer.parseInt(b_id));
		mav.addObject("check", check);
		return mav;
	}
}
