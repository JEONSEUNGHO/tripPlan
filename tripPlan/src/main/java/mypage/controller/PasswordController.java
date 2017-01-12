package mypage.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.MemberInfo;
import mypage.dao.PasswordDAO;
import net.sf.json.JSONObject;

@Controller
public class PasswordController {

	@Autowired
	private PasswordDAO passDAO;

	public void setService(PasswordDAO passDAO) {
		this.passDAO = passDAO;
	}

	@RequestMapping(value = "/pass.do", method = RequestMethod.POST)
	public String submit(MemberInfo memberInfo, HttpServletRequest request) {
		
		String m_email = (String) request.getSession().getAttribute("m_email");
		memberInfo.setM_email(m_email);
		
		int check = passDAO.updatePass(memberInfo);
		System.out.println("[INFO] 비밀번호 변경 성공!!");
		
		return "redirect:/tiles/mypage.do?check="+check;
	}
	
	// 회원가입 페이지에서 실시간 아이디체크 페이지 요청
	@RequestMapping(value = "/passchk.do", method = RequestMethod.POST)
	public void submit2(MemberInfo memberInfo, HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		// session에서 이메일 받아오기
		String m_email = (String) request.getSession().getAttribute("m_email");
		String str = "";
		int flag = passDAO.getPass(memberInfo, m_email);

		// 비밀번호 불일치
		if (flag == -1) {
			str = "NO";
		}
		// 비밀번호 일치
		if (flag == 1) {
			str = "YES";
		}

		JSONObject jso = new JSONObject(); // JASON 객체생성
		jso.put("data", str); // jason은 map구조(키,값), data라는 key로 list데이터를 주입했다.

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jso.toString()); // out.print 내용을 ajax의 dataType이 jason에게 데이터
									// 쏴줌
	}

}
