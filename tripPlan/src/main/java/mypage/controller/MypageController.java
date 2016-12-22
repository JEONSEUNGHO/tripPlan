package mypage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MypageController {

	@RequestMapping(value = "/mypage.do", method = RequestMethod.GET)
	public String form(HttpServletRequest request) {
		request.getSession().getAttribute("m_email");
		request.getSession().getAttribute("m_profile");
		
		return "mypage";
	}
	
}




