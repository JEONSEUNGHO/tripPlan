package send.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import receive.DAO.ReceiveDataBean;
import send.DAO.SendDataBean;
import send.Service.SendService;

@Controller
public class SendUpdate {
	@Autowired
	private SendService service;

	public void setService(SendService service) {
		this.service = service;
	}

	@RequestMapping(value = "/updateForm.do")
	public String sut(int sm_id, String pageNum, Model model) throws Throwable {

		SendDataBean send = service.getSend(sm_id);

		// 해당 뷰에서 사용할 속성
		model.addAttribute("pageNum", new Integer(pageNum));
		model.addAttribute("send", send);

		return "updateForm";// 해당뷰
	}

	@RequestMapping(value = "/updatePro.do")
	public String sutp(SendDataBean send, String pageNum, Model model) throws Throwable {

		int check = service.updateSend(send, send.getSm_check());

		model.addAttribute("pageNum", pageNum);
		model.addAttribute("check", check);

		return "updatePro";
	}
}
