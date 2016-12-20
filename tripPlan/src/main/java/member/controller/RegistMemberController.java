package member.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.Code;
import member.model.MemberInfo;
import member.validator.MemberInfoValidator;

@Controller
public class RegistMemberController {

	@RequestMapping(value = "/regist.do", method = RequestMethod.GET)
	public String form() {
		return "registMemberForm";
	}

	@ModelAttribute
	protected Object formBackingObject() throws Exception {
		return new MemberInfo();

	}

	private void referenceData(Model model) {
		List<Code> ageCodes = new ArrayList<Code>();
		ageCodes.add(new Code("10대", "10대"));
		ageCodes.add(new Code("20대", "20대"));
		ageCodes.add(new Code("30대", "30대"));
		ageCodes.add(new Code("40대", "40대"));
		ageCodes.add(new Code("50대 이상", "50대 이상"));
		
		model.addAttribute("m_agerange", ageCodes);


	}

	@RequestMapping(value = "/regist2.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute MemberInfo memberInfo, BindingResult result, Model model) {
		new MemberInfoValidator().validate(memberInfo, result);
		if (result.hasErrors()) {
			result.reject("errorInfo");
			return "registMemberForm";
		}
		referenceData(model);
		return "registMemberForm2";
	}

}
