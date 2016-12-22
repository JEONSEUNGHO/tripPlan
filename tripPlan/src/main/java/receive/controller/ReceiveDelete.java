package receive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import receive.Service.ReceiveService;

@Controller
public class ReceiveDelete {
	@Autowired
	private ReceiveService service;

	public void setService(ReceiveService service) {
		this.service = service;
	}

	@RequestMapping(value = "/receive/deleteForm")
	public String rdt(int rm_id, String pageNum, Model model) throws Throwable {

		model.addAttribute("rm_id", new Integer(rm_id));
		model.addAttribute("pageNum", new Integer(pageNum));

		return "deleteForm";
	}

	@RequestMapping(value = "/receive/delete")
	public String rdtp(int rm_id, String pageNum, String rm_check, Model model) throws Throwable {

		int check = service.rdt(rm_id, rm_check);

		model.addAttribute("pageNum", pageNum);
		model.addAttribute("check", check);

		return "receive/deletePro";
	}
}
