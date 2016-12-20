package send.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import send.DAO.SendDataBean;
import send.Service.sendService;

@Controller
@RequestMapping("/send/update")
public class SendUpdate {
	@Autowired
	private sendService service;

	public void setService(sendService service) {
		this.service = service;

	}

	@RequestMapping(value = "view/send/updateForm.do")
	public String update(int sm_id, String pageNum, Model model) throws Throwable {

		SendDataBean send = service.getSend(sm_id);

		model.addAttribute("pageNum", new Integer(pageNum));
		model.addAttribute("send", send);

		return "view/send/updateForm";
	}

	@RequestMapping(value = "view/send/updatePro.do")
	public String updatePro(SendDataBean send, String pageNum, Model model) throws Throwable {

		int check = service.updatesend(send);

		model.addAttribute("pageNum", pageNum);
		model.addAttribute("check", check);

		return "view/send/updatePro";
	}
}