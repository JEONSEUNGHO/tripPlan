package receive.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import receive.Service.ReceiveService;

@Controller
public class ReceiveController {
	@Autowired
	private ReceiveService service;

	public void setService(ReceiveService service) {
		this.service = service;
	}

	@RequestMapping(value = "/receive/receive")
	public String rcr(String pageNum, String search, @RequestParam(defaultValue = "0") int searchn, Model model)
			throws Throwable {

		if (pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 5;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int number = 0;

		List receiveList = null;

		count = service.getReceiveCount(search, searchn);

		if (count > 0) {
			receiveList = service.getReceives(startRow, endRow, search, searchn);
		} else {
			receiveList = Collections.EMPTY_LIST;
		}

		number = count - (currentPage - 1) * pageSize;

		model.addAttribute("currentPage", new Integer(currentPage));
		model.addAttribute("startRow", new Integer(startRow));
		model.addAttribute("endRow", new Integer(endRow));
		model.addAttribute("count", new Integer(count));
		model.addAttribute("pageSize", new Integer(pageSize));
		model.addAttribute("number", new Integer(number));
		model.addAttribute("receiveList", receiveList);

		return "receive/receive";
	}

}
