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
		System.out.println("[INFO] ��й�ȣ ���� ����!!");
		
		return "redirect:/tiles/mypage.do?check="+check;
	}
	
	// ȸ������ ���������� �ǽð� ���̵�üũ ������ ��û
	@RequestMapping(value = "/passchk.do", method = RequestMethod.POST)
	public void submit2(MemberInfo memberInfo, HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		// session���� �̸��� �޾ƿ���
		String m_email = (String) request.getSession().getAttribute("m_email");
		String str = "";
		int flag = passDAO.getPass(memberInfo, m_email);

		// ��й�ȣ ����ġ
		if (flag == -1) {
			str = "NO";
		}
		// ��й�ȣ ��ġ
		if (flag == 1) {
			str = "YES";
		}

		JSONObject jso = new JSONObject(); // JASON ��ü����
		jso.put("data", str); // jason�� map����(Ű,��), data��� key�� list�����͸� �����ߴ�.

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jso.toString()); // out.print ������ ajax�� dataType�� jason���� ������
									// ����
	}

}
