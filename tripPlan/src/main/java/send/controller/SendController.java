package send.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import send.dao.SendDataBean;
import send.service.SendService;

@Controller
public class SendController {
	@Autowired
	private SendService service;
	
	public void setService(SendService service) {
		this.service = service;
	}
	@RequestMapping(value = "sendwrite")
	public String sendwrite(@ModelAttribute("send")SendDataBean send) throws Throwable {
		
		return "send/sendwrite";
	}
	@RequestMapping(value = "sendwritePro")
	public String writePro(SendDataBean send, HttpServletRequest request) throws Throwable {
		send.setM_email(request.getRemoteAddr());
		service.insert(send);
		return "send/sendwritePro";
	}

}
