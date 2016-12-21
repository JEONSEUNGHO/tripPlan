package receive.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import receive.DAO.ReceiveDataBean;
import receive.Service.receiveService;

@Controller
@RequestMapping("/receive/write")
public class ReceiveWrite {
	@Autowired
	private receiveService service;

	public void setService(receiveService service) {
		this.service = service;

	}
	@RequestMapping(value = "/writePro.do")
	public String receivewrite(ReceiveDataBean receive, HttpServletRequest request) throws Throwable {
		receive.setRm_sender(request.getRemoteAddr());
		service.insertreceive(receive);
		return "view/receive/receivewrite";
	}
}
