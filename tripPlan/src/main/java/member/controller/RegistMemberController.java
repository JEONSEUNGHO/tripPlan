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

    //회원가입 클릭 시 네이버 간편로그인 url 등록
    private NaverLoginBO naverLoginBO;

    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO){
        this.naverLoginBO = naverLoginBO;
    }
    // 헤더에서 회원가입 버튼 클릭 시 
    @RequestMapping("/regist.do")
    public ModelAndView login(HttpSession session, MemberInfo memberInfo) {
        /* 네아로 인증 URL을 생성하기 위하여 getAuthorizationUrl을 호출 */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        if(memberInfo.getM_email() != null) {
        	new MemberInfo();
        }
        
        /* 생성한 인증 URL을 View로 전달 */
        return new ModelAndView("registMemberForm", "url", naverAuthUrl);
    }


	@ModelAttribute
	protected Object formBackingObject() throws Exception {
		return new MemberInfo();

	}
	// 회원가입1에서 다음 버튼 클릭 시 
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
