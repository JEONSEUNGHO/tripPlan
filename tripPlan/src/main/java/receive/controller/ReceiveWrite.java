package receive.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import receive.DAO.ReceiveDataBean;
import receive.Service.ReceiveService;

@Controller
public class ReceiveWrite {
	@Autowired
	private ReceiveService service;

	public void setService(ReceiveService service) {
		this.service = service;
	}

	@RequestMapping(value = "/receive/writeForm")
	public String rwt(@ModelAttribute("board") ReceiveDataBean board) throws Throwable {

		return "writeForm";
	}

	@RequestMapping(value = "/writePro.do")
	public String rwtp(ReceiveDataBean receive, HttpServletRequest request) throws Throwable {
		receive.setRm_sender(request.getRemoteAddr());
		service.insert(receive);
		return "receive/writePro";
	}
}
