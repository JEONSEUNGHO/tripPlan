package send.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import send.dao.SendDataBean;
import send.service.SendService;

@Controller
public class SendListController {
	@Autowired
	private SendService service;
	
	public void setService(SendService service) {
		this.service = service;
	}
	@RequestMapping(value = "/send.do")
	public String view(String pageNum, Model model)  throws Throwable {
		if (pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 5;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int number = 0;
		List<SendDataBean> sendList = new ArrayList<>();
		System.out.println("??");
		sendList = service.getSends(startRow, endRow);
		
		model.addAttribute("currentPage", new Integer(currentPage));
		model.addAttribute("startRow", new Integer(startRow));
		model.addAttribute("endRow", new Integer(endRow));
		model.addAttribute("count", new Integer(count));
		model.addAttribute("pageSize", new Integer(pageSize));
		model.addAttribute("sendList", sendList);
		
		return "send/send";
	}

}
