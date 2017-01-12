package mypage.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.controller.SendEmail;
import member.model.MemberInfo;
import mypage.dao.MypageDAO;


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
	public String form(MemberInfo memberInfo, HttpServletRequest request, Model model, HttpServletResponse response) {
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

			// DB에서 가져올 mypage화면에 필요한 정보 m_email, m_profile, m_identified, m_nickname, m_sex, m_agerange
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
					e.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				System.out.println("메일 전송 성공!!");
				return "mypagewait";
				// 사용자가 인증완료면
			} else if (m_identified == 1) {
				request.getSession().setAttribute("m_profile", memberInfo.getM_profile());
				model.addAttribute("m_nickname", memberInfo.getM_nickname());
				model.addAttribute("m_sex", memberInfo.getM_sex());
				model.addAttribute("m_agerange", memberInfo.getM_agerange());
				model.addAttribute("m_identified", memberInfo.getM_identified());
			
				return "mypage";
				// 사용자가 네이버 인증회원이면
			} else if (m_identified == 2) {
				request.getSession().setAttribute("m_profile", memberInfo.getM_profile());
				model.addAttribute("m_nickname", memberInfo.getM_nickname());
				model.addAttribute("m_sex", memberInfo.getM_sex());
				model.addAttribute("m_agerange", memberInfo.getM_agerange());
				model.addAttribute("m_identified", memberInfo.getM_identified());
				
				return "mypage";
		   // 사용자가 정지회원이면
			} else if (m_identified == 3) {
				return "mypageblock";
			} // 사용자가 관리자이면 
			return "admin";
		}
	
	@SuppressWarnings("unchecked")
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
	
	// Follow 검색창 요청 처리
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/finduser.do", method = RequestMethod.POST)
	public void submit(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setCharacterEncoding("utf-8");
		// follow 검색창에서 입력받은 키워드를 가져옴 
		String searchValue = request.getParameter("searchUser");
		// 내가 follow한 사람들의 정보를 가져오기 위해 session에서 내 이메일을 가져옴 
		String m_email = (String) request.getSession().getAttribute("m_email");
		
		JSONArray arrayObj = new JSONArray();
		JSONObject jsonObj = null;
		ArrayList<String> dblist = null;
		// 검색어를 입력하지 않았을 경우 or 입력했다 모두 지웠을 경우 내가 follow한 목록으로 넘어가게 하는 처리 
		if(searchValue.equals("")) {
			 dblist= (ArrayList<String>) dao.findfollow(m_email);
			
		} else {
			 dblist = (ArrayList<String>) dao.finduser(m_email);
		}

		// tl_member에 있는 모든 데이터를 가져온다
		ArrayList<String> resultlist = new ArrayList<String>();

		// DB에서 가져온 데이터를 비교
		for (String str : dblist) {
			if (str.toLowerCase().startsWith(searchValue) || str.toLowerCase().endsWith(searchValue) || str.indexOf(searchValue)>=1) {
				resultlist.add(str);
			}
		}
		// 뽑은 후 json파싱
		for (String str : resultlist) {
			jsonObj = new JSONObject();
			jsonObj.put("data", str);
			arrayObj.add(jsonObj);
		}

		PrintWriter pw = response.getWriter();
		pw.print(arrayObj);
		pw.flush();
		pw.close();
	} 
	
	@RequestMapping(value = "/addfollow.do", method = RequestMethod.POST)
	public String submit(HttpServletRequest request) {
		// follow 검색창에서 입력받은 키워드를 가져옴 
		String f_email = request.getParameter("f_email");
		// 내가 follow한 사람들의 정보를 가져오기 위해 session에서 내 이메일을 가져옴 
		String m_email = (String) request.getSession().getAttribute("m_email");
		dao.addfollow(f_email, m_email);
		System.out.println("insert성공");
		
		return "mypage";
	}
	 
	@RequestMapping(value = "/delfollow.do", method = RequestMethod.POST)
	public String submit2(HttpServletRequest request) {
		// follow 검색창에서 입력받은 키워드를 가져옴 
		String f_email = request.getParameter("f_email");
		// 내가 follow한 사람들의 정보를 가져오기 위해 session에서 내 이메일을 가져옴 
		String m_email = (String) request.getSession().getAttribute("m_email");
		dao.delfollow(f_email, m_email);
		System.out.println("delete성공");
		
		return "mypage";
	}
}

