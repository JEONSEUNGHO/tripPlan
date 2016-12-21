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
import member.model.MemberInfo;
import member.validator.MemberInfoValidator;

@Controller
public class RegistMemberController {
	
    //회원가입 클릭 시 네이버 간편로그인 url 등록
    private NaverLoginBO naverLoginBO;

    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO){
        this.naverLoginBO = naverLoginBO;
    }

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

	@RequestMapping(value = "/regist2.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute MemberInfo memberInfo, BindingResult result, Model model) {
		new MemberInfoValidator().validate(memberInfo, result);
		if (result.hasErrors()) {
			result.reject("errorInfo");
			return "registMemberForm";
		}
		return "registMemberForm2";
	}

}
