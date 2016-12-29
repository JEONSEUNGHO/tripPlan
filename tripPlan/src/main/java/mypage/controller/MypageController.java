package mypage.controller;

import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.controller.SendEmail;
import member.model.MemberInfo;
import mypage.dao.MypageDAO;
import net.sf.json.JSONObject;

@Controller
public class MypageController {

	MypageDAO dao;

	public void setDao(MypageDAO dao) {
		this.dao = dao;
	}

	@Autowired
	SendEmail sendemail;

	public void setSendemail(SendEmail sendemail) {
		this.sendemail = sendemail;
	}

	@RequestMapping(value = "/mypage.do", method = RequestMethod.GET)
	public String form(MemberInfo memberInfo, HttpServletRequest request) {
		// 해당 페이지의 session값 받아오기
		String m_email = (String) request.getSession().getAttribute("m_email");
		// 이메일 인증 후 authkey값 리턴 받아오기
		String authkey = request.getParameter("authkey");
		if (authkey==null) {
			authkey="";
			
		} else if(authkey!=null) {
			// m_identified 0 > 1로 변경
			dao.verifySuccess(m_email);
			System.out.println("이메일 인증 완료!!");
			
		}

			// DB에서 가져올 mypage화면에 필요한 정보 m_email, m_profile, m_identified
			memberInfo = dao.userIdentified(m_email);

			// DB에서 가져온 정보 m_profile, m_identified
			int m_identified = memberInfo.getM_identified();

			// 사용자가 가입대기중이면
			if (m_identified == 0) {
				try {
					String subject = "triP plan 회원가입 인증메일 입니다.";
					String content = "Please click on the link below for verification " + 
							"<br><br> <a href=http://localhost:8088/tripPlan/tiles/mypage.do?authkey=1>verify</a>";
					
					sendemail.generateAndSendEmail(memberInfo, subject, content);
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("메일 전송 성공!!");
				return "mypagewait";
				// 사용자가 인증완료면
			} else if (m_identified == 1) {
				return "mypage";
				// 사용자가 정지회면이면
			} else if (m_identified == 2) {
				return "mypageblock";
			} // 사용자가 관리자라면
			return "admin";
		}
	
	@RequestMapping(value = "/realtimeCount.do", method = RequestMethod.GET)
	public void form1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 세션에 저장된 이메일을 가져온다 
		String m_email = (String) request.getSession().getAttribute("m_email");
		
		int realtimeCount = dao.realtimeCount(m_email);
		

		JSONObject jso = new JSONObject(); // JASON 객체생성
		jso.put("data", realtimeCount); // jason은 map구조(키,값), data라는 key로 list데이터를 주입했다.

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jso.toString()); // out.print
									// 내용을
									// ajax의dataType이 jason에게데이터 쏴줌
	
	}
}

