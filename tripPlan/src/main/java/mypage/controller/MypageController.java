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
		// �ش� �������� session�� �޾ƿ���
		String m_email = (String) request.getSession().getAttribute("m_email");
		// �̸��� ���� �� authkey�� ���� �޾ƿ���
		String authkey = request.getParameter("authkey");
		if (authkey==null) {
			authkey="";
			
		} else if(authkey!=null) {
			// m_identified 0 > 1�� ����
			dao.verifySuccess(m_email);
			System.out.println("�̸��� ���� �Ϸ�!!");
		}

			// DB���� ������ mypageȭ�鿡 �ʿ��� ���� m_email, m_profile, m_identified, m_nickname, m_sex, m_agerange
			memberInfo = dao.userIdentified(m_email);
			
			// DB���� ������ ���� m_profile, m_identified
			int m_identified = memberInfo.getM_identified();
			// ����ڰ� ���Դ�����̸�
			if (m_identified == 0) {
				try {
					String subject = "triP plan ȸ������ �������� �Դϴ�.";
					String content = "Please click on the link below for verification " + 
							"<br><br> <a href=http://localhost:8088/tripPlan/tiles/mypage.do?authkey=1>verify</a>";
					
					sendemail.generateAndSendEmail(memberInfo, subject, content);
				} catch (AddressException e) {
					e.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				System.out.println("���� ���� ����!!");
				return "mypagewait";
				// ����ڰ� �����Ϸ��
			} else if (m_identified == 1) {
				request.getSession().setAttribute("m_profile", memberInfo.getM_profile());
				model.addAttribute("m_nickname", memberInfo.getM_nickname());
				model.addAttribute("m_sex", memberInfo.getM_sex());
				model.addAttribute("m_agerange", memberInfo.getM_agerange());
				model.addAttribute("m_identified", memberInfo.getM_identified());
			
				return "mypage";
				// ����ڰ� ���̹� ����ȸ���̸�
			} else if (m_identified == 2) {
				request.getSession().setAttribute("m_profile", memberInfo.getM_profile());
				model.addAttribute("m_nickname", memberInfo.getM_nickname());
				model.addAttribute("m_sex", memberInfo.getM_sex());
				model.addAttribute("m_agerange", memberInfo.getM_agerange());
				model.addAttribute("m_identified", memberInfo.getM_identified());
				
				return "mypage";
		   // ����ڰ� ����ȸ���̸�
			} else if (m_identified == 3) {
				return "mypageblock";
			} // ����ڰ� �������̸� 
			return "admin";
		}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/realtimeCount.do", method = RequestMethod.GET)
	public void form1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ���ǿ� ����� �̸����� �����´� 
		String m_email = (String) request.getSession().getAttribute("m_email");
		
		int realtimeCount = dao.realtimeCount(m_email);
		

		JSONObject jso = new JSONObject(); // JASON ��ü����
		jso.put("data", realtimeCount); // jason�� map����(Ű,��), data��� key�� list�����͸� �����ߴ�.

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jso.toString()); // out.print
									// ������
									// ajax��dataType�� jason���Ե����� ����
	
	}
	
	// Follow �˻�â ��û ó��
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/finduser.do", method = RequestMethod.POST)
	public void submit(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setCharacterEncoding("utf-8");
		// follow �˻�â���� �Է¹��� Ű���带 ������ 
		String searchValue = request.getParameter("searchUser");
		// ���� follow�� ������� ������ �������� ���� session���� �� �̸����� ������ 
		String m_email = (String) request.getSession().getAttribute("m_email");
		
		JSONArray arrayObj = new JSONArray();
		JSONObject jsonObj = null;
		ArrayList<String> dblist = null;
		// �˻�� �Է����� �ʾ��� ��� or �Է��ߴ� ��� ������ ��� ���� follow�� ������� �Ѿ�� �ϴ� ó�� 
		if(searchValue.equals("")) {
			 dblist= (ArrayList<String>) dao.findfollow(m_email);
			
		} else {
			 dblist = (ArrayList<String>) dao.finduser(m_email);
		}

		// tl_member�� �ִ� ��� �����͸� �����´�
		ArrayList<String> resultlist = new ArrayList<String>();

		// DB���� ������ �����͸� ��
		for (String str : dblist) {
			if (str.toLowerCase().startsWith(searchValue) || str.toLowerCase().endsWith(searchValue) || str.indexOf(searchValue)>=1) {
				resultlist.add(str);
			}
		}
		// ���� �� json�Ľ�
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
		// follow �˻�â���� �Է¹��� Ű���带 ������ 
		String f_email = request.getParameter("f_email");
		// ���� follow�� ������� ������ �������� ���� session���� �� �̸����� ������ 
		String m_email = (String) request.getSession().getAttribute("m_email");
		dao.addfollow(f_email, m_email);
		System.out.println("insert����");
		
		return "mypage";
	}
	 
	@RequestMapping(value = "/delfollow.do", method = RequestMethod.POST)
	public String submit2(HttpServletRequest request) {
		// follow �˻�â���� �Է¹��� Ű���带 ������ 
		String f_email = request.getParameter("f_email");
		// ���� follow�� ������� ������ �������� ���� session���� �� �̸����� ������ 
		String m_email = (String) request.getSession().getAttribute("m_email");
		dao.delfollow(f_email, m_email);
		System.out.println("delete����");
		
		return "mypage";
	}
}

