package send.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import send.Service.sendService;

@Controller
@RequestMapping("/send/delete")
public class SendDelete {
	@Autowired
	private sendService service;

	public void setService(sendService service) {
		this.service = service;
		
	}
	@RequestMapping(value = "view/send/deleteForm.do")
	public String delete(int sm_id, String pageNum, Model model) throws Throwable {

		// �ش� �信�� ����� �Ӽ�
		model.addAttribute("num", new Integer(sm_id));
		model.addAttribute("pageNum", new Integer(pageNum));

		return "view/send/deleteForm";// �ش��
	}
	@RequestMapping(value = "view/send/deletePro.do")
	public String deletePro(int sm_id, String pageNum, Model model) throws Throwable {

		int check = service.deletesend(sm_id);

		// �ش� �信�� ����� �Ӽ�
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("check", check);

		return "view/send/deletePro";// �ش��
	}
}