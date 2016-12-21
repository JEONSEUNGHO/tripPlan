package send.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import send.Service.SendService;

@Controller
public class SendDelete {
	@Autowired
	private SendService service;

	public void setService(SendService service) {
		this.service = service;
	}

	@RequestMapping(value = "/deleteForm.do")
	public String sdt(int sm_id, String pageNum, Model model) throws Throwable {

		model.addAttribute("sm_id", new Integer(sm_id));
		model.addAttribute("pageNum", new Integer(pageNum));

		return "deleteForm";
	}

	@RequestMapping(value = "/deletePro.do")
	public String sdtp(int sm_id, String pageNum, String sm_check, Model model) throws Throwable {

		int check = service.sdt(sm_id, sm_check);

		model.addAttribute("pageNum", pageNum);
		model.addAttribute("check", check);

		return "deletePro";
	}
}
