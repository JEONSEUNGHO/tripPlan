package receive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import receive.DAO.ReceiveDataBean;
import receive.Service.receiveService;

@Controller
@RequestMapping("/receive/content")
public class ReceiveContent {
	@Autowired
	private receiveService service;

	public void setService(receiveService service) {
		this.service = service;
		
	}
	@RequestMapping(value = "view/receive/content.do", method = RequestMethod.GET)
	public String requestPro(@RequestParam("rm_id") int rm_id, String pageNum, Model model){
		ReceiveDataBean receiveList = null;
		service.readcount(rm_id);
		receiveList = service.getReceive(rm_id);
		
		model.addAttribute("rm_id", new Integer(rm_id));
		model.addAttribute("pageNum", new Integer(pageNum));
		model.addAttribute("receive", receiveList);
		
		return "view/receive/content";
	}
}
