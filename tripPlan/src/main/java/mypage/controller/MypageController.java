package mypage.controller;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String form(MemberInfo memberInfo, HttpServletRequest request) {
		// �ش� �������� session�� �޾ƿ���
		String m_email = (String) request.getSession().getAttribute("m_email");
		// session�� �������� ���� ��� ex) ������ ���� ����
		if(m_email==null) {
			return "main";
		}
		// �̸��� ���� �� authkey�� ���� �޾ƿ���
		String authkey = request.getParameter("authkey");
		if (authkey==null) {
			authkey="";
			
		} else if(authkey!=null) {
			// m_identified 0 > 1�� ����
			dao.verifySuccess(m_email);
			System.out.println("�̸��� ���� �Ϸ�!!");
			
		}

			// DB���� ������ mypageȭ�鿡 �ʿ��� ���� m_email, m_profile, m_identified
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("���� ���� ����!!");
				return "mypagewait";
				// ����ڰ� �����Ϸ��
			} else if (m_identified == 1) {
				return "mypage";
				// ����ڰ� ����ȸ���̸�
			} else if (m_identified == 2) {
				return "mypageblock";
			} // ����ڰ� �����ڶ��
			return "admin";
		}
	
}
