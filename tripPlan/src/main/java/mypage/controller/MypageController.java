package mypage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.MemberInfo;

@Controller
public class MypageController {

	@RequestMapping(value = "/mypage.do", method = RequestMethod.GET)
	public String form(MemberInfo memberInfo, HttpServletRequest request) {
		request.getSession().setAttribute("m_email", memberInfo.getM_email());
		
		return "mypage";
	}
	
}




