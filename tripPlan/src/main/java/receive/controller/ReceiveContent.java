package receive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import receive.DAO.ReceiveDataBean;
import receive.Service.ReceiveService;

@Controller
public class ReceiveContent {
	@Autowired
	private ReceiveService service;

	public void setService(ReceiveService service) {
		this.service = service;
	}

	@RequestMapping(value = "/content.do", method = RequestMethod.GET)
	public String rct(@RequestParam("rm_id") int rm_id, String pageNum, Model model) {

		ReceiveDataBean receiveList = null;
		service.readcount(rm_id);
		receiveList = service.getReceive(rm_id);

		model.addAttribute("rm_id", new Integer(rm_id));
		model.addAttribute("pageNum", new Integer(pageNum));
		model.addAttribute("receive", receiveList);

		return "content";
	}

}