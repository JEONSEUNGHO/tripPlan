package receive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import receive.DAO.ReceiveDataBean;
import receive.Service.receiveService;

@Controller
@RequestMapping("/receive/update")
public class ReceiveUpdate {
	@Autowired
	private receiveService service;

	public void setService(receiveService service) {
		this.service = service;

	}

	@RequestMapping(value = "view/receive/updateForm.do")
	public String update(int rm_id, String pageNum, Model model) throws Throwable {

		ReceiveDataBean receive = service.getReceive(rm_id);

		model.addAttribute("pageNum", new Integer(pageNum));
		model.addAttribute("receive", receive);

		return "view/receive/updateForm";
	}

	@RequestMapping(value = "view/receive/updatePro.do")
	public String updatePro(ReceiveDataBean receive, String pageNum, Model model) throws Throwable {

		int check = service.updatereceive(receive);

		model.addAttribute("pageNum", pageNum);
		model.addAttribute("check", check);

		return "view/receive/updatePro";
	}
}