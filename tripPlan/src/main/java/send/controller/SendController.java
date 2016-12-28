package send.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import send.dao.SendDataBean;
import send.service.SendService;
import send.validator.SendValidator;

@Controller
public class SendController {
	
	@Autowired
	private SendService service;

	public void setService(SendService service) {
		this.service = service;
	}

	@RequestMapping(value = "/sendwrite.do", method = RequestMethod.GET)
	public String sendwrite(SendDataBean send)  {

		return "send/sendwrite";
	}

	@RequestMapping(value = "/sendwritePro.do", method = RequestMethod.POST)
	public String writePro(@ModelAttribute SendDataBean send, BindingResult result, HttpServletRequest request) {
		new SendValidator().validate(send, result);
		// 유효성 검사 에러 발생 시
		if(result.hasErrors()) {
			return "send/sendwrite";
		}
		send.setM_email((String) (request.getSession().getAttribute("m_email")));
		service.insert(send);
		return "send/send";
	}

	@ModelAttribute
	protected SendDataBean formBack() throws Exception {
		return new SendDataBean();

	}



}
