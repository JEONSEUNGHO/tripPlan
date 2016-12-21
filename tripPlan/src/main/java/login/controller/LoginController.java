package login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import login.validator.LoginValidator;
import member.model.MemberInfo;


@Controller
public class LoginController {

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String form() {
		return "loginForm";
	}
	
	@ModelAttribute
	protected Object formBackingObject() throws Exception {
		return new MemberInfo();
	}
	
	@RequestMapping(value = "/loginPro.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute MemberInfo memberInfo, BindingResult result) {
		new LoginValidator().validate(memberInfo, result);
		if (result.hasErrors()) {
			result.reject("errorInfo");
			return "loginForm";
		}
		return "myPage";
	}

}
