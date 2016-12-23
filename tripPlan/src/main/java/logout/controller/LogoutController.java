package logout.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout.do")
	public String form(HttpServletRequest request) {
		// ���� ������ ����
		request.getSession().invalidate();
		return "main";
	}
}
