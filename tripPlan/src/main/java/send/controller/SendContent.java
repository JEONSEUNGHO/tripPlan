package send.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import send.DAO.SendDataBean;
import send.Service.sendService;

@Controller
@RequestMapping("/send/content")
public class SendContent {
	@Autowired
	private sendService service;

	public void setService(sendService service) {
		this.service = service;
		
	}
	@RequestMapping(value = "view/send/content.do", method = RequestMethod.GET)
	public String requestPro(@RequestParam("sm_id") int sm_id, String pageNum, Model model){
		SendDataBean sendList = null;
		service.readcount(sm_id);
		sendList = service.getSend(sm_id);
		
		model.addAttribute("sm_id", new Integer(sm_id));
		model.addAttribute("pageNum", new Integer(pageNum));
		model.addAttribute("send", sendList);
		
		return "view/send/content";
	}
}

