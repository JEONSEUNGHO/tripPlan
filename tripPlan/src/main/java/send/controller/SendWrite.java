package send.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import send.DAO.SendDataBean;
import send.Service.SendService;

@Controller
public class SendWrite {
	@Autowired
	private SendService service;

	public void setService(SendService service) {
		this.service = service;
	}

	@RequestMapping(value = "/writeForm.do")
	public String swt(@ModelAttribute("board") SendDataBean board) throws Throwable {

		return "writeForm";
	}

	@RequestMapping(value = "/writePro.do")
	public String swtp(SendDataBean send, HttpServletRequest request) throws Throwable {
		send.setSm_receive(request.getRemoteAddr());
		service.insert(send);
		return "writePro";
	}
}
