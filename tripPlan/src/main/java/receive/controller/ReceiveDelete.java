package receive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import receive.Service.receiveService;

@Controller
@RequestMapping("/receive/delete")
public class ReceiveDelete {
	@Autowired
	private receiveService service;

	public void setService(receiveService service) {
		this.service = service;
		
	}
	@RequestMapping(value = "view/receive/deleteForm.do")
	public String delete(int rm_id, String pageNum, Model model) throws Throwable {

		// �ش� �信�� ����� �Ӽ�
		model.addAttribute("num", new Integer(rm_id));
		model.addAttribute("pageNum", new Integer(pageNum));

		return "view/receive/deleteForm";// �ش��
	}
	@RequestMapping(value = "view/receive/deletePro.do")
	public String deletePro(int rm_id, String pageNum, Model model) throws Throwable {

		int check = service.deletereceive(rm_id);

		// �ش� �信�� ����� �Ӽ�
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("check", check);

		return "view/receive/deletePro";// �ش��
	}
}