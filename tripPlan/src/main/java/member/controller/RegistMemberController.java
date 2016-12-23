package member.controller;

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
