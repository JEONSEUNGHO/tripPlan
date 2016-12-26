package member.controller;

import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import login.controller.NaverLoginBO;
import member.dao.MemberDAO;
import member.model.MemberInfo;
import member.validator.MemberInfoValidator;
import net.sf.json.JSONObject;

@Controller
public class RegistMemberController {
	
	MemberDAO dao;

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

    //ȸ������ Ŭ�� �� ���̹� ����α��� url ���
    private NaverLoginBO naverLoginBO;

    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO){
        this.naverLoginBO = naverLoginBO;
    }
    // ȸ������ ���������� �ǽð� ���̵�üũ ������ ��û
	@RequestMapping(value = "/idchk.do", method = RequestMethod.POST)
	public void submit(HttpServletResponse response, HttpServletRequest request) throws Exception {
	      String m_email = request.getParameter("m_email");
	        int flag = -1;
	        String str = "";
	        
			// �̸��� ��ȿ�� �˻�
			Pattern p1 = Pattern.compile("[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}");
			Matcher m1 = p1.matcher(m_email);
			// host ���� �߻� �� 
	        if(m_email == null){
	            m_email = "";
	        }        
	        if(!(m_email.equals(""))){
	            flag = dao.realTimeIdchk(m_email);
	        }
	        if(!(m1.find())) { 
	        	flag = -1;
	        }
	        // ��ȿ�� �˻�
	        if(flag==-1) {
	        	str = "ERROR";
	        }
	        // �̹� �����ϴ� ����
	        if(flag==1){    
	            str = "NO";
	        }
	        // ��밡���� ����
	        if(flag==0){        
	            str = "YES";
	        } 
		JSONObject jso = new JSONObject(); // JASON ��ü����
		jso.put("data", str); // jason�� map����(Ű,��), data��� key�� list�����͸� �����ߴ�.

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jso.toString()); // out.print ������ ajax�� dataType�� jason���� ������ ����
	}
 
    // ������� ȸ������ ��ư Ŭ�� �� 
    @RequestMapping("/regist.do")
    public ModelAndView login(HttpSession session, MemberInfo memberInfo) {
        /* �׾Ʒ� ���� URL�� �����ϱ� ���Ͽ� getAuthorizationUrl�� ȣ�� */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        if(memberInfo.getM_email() != null) {
        	new MemberInfo();
        }
        
        /* ������ ���� URL�� View�� ���� */
        return new ModelAndView("registMemberForm", "url", naverAuthUrl);
    }


	@ModelAttribute
	protected Object formBackingObject() throws Exception {
		return new MemberInfo();

	}
	// ȸ������1���� ���� ��ư Ŭ�� �� 
	@RequestMapping(value = "/regist.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute MemberInfo memberInfo, BindingResult result, Model model, HttpSession session) {
		new MemberInfoValidator().validate(memberInfo, result);
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		if (result.hasErrors()) {
			result.reject("errorInfo");
			model.addAttribute("url", naverAuthUrl);
			return "registMemberForm";
		}
		return "registMemberForm2";
	}

}
