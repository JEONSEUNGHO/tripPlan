package receive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import receive.DAO.ReceiveDataBean;
import receive.Service.ReceiveService;

@Controller
public class ReceiveUpdate {
	@Autowired
	private ReceiveService service;

	public void setService(ReceiveService service) {
		this.service = service;
	}

	@RequestMapping(value = "/receive/updateForm")
	public String rut(int rm_id, String pageNum, Model model) throws Throwable {

		ReceiveDataBean receive = service.getReceive(rm_id);

		// 해당 뷰에서 사용할 속성
		model.addAttribute("pageNum", new Integer(pageNum));
		model.addAttribute("receive", receive);

		return "updateForm";// 해당뷰
	}

	@RequestMapping(value = "/updatePro.do")
	public String rutp(ReceiveDataBean receive, String pageNum, Model model) throws Throwable {

		int check = service.updateReceive(receive, receive.getRm_check());

		model.addAttribute("pageNum", pageNum);
		model.addAttribute("check", check);

		return "receive/updatePro";
	}
}
