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

		// 해당 뷰에서 사용할 속성
		model.addAttribute("num", new Integer(rm_id));
		model.addAttribute("pageNum", new Integer(pageNum));

		return "view/receive/deleteForm";// 해당뷰
	}
	@RequestMapping(value = "view/receive/deletePro.do")
	public String deletePro(int rm_id, String pageNum, Model model) throws Throwable {

		int check = service.deletereceive(rm_id);

		// 해당 뷰에서 사용할 속성
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("check", check);

		return "view/receive/deletePro";// 해당뷰
	}
}