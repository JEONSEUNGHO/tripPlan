package send.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import send.Service.SendService;

@Controller
public class SendController {
	@Autowired
	private SendService service;

	public void setService(SendService service) {
		this.service = service;
	}

	@RequestMapping(value = "/list.do")
	public String scr(String pageNum, String search, @RequestParam(defaultValue = "0") int searchn, Model model)
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

		List sendList = null;

		count = service.getSendCount(search, searchn);

		if (count > 0) {
			sendList = service.getSends(startRow, endRow, search, searchn); // 글
																			// 목록
		} else {
			sendList = Collections.EMPTY_LIST;
		}

		number = count - (currentPage - 1) * pageSize;
		// 해당 뷰에서 사용할 속성
		model.addAttribute("currentPage", new Integer(currentPage));
		model.addAttribute("startRow", new Integer(startRow));
		model.addAttribute("endRow", new Integer(endRow));
		model.addAttribute("count", new Integer(count));
		model.addAttribute("pageSize", new Integer(pageSize));
		model.addAttribute("number", new Integer(number));
		model.addAttribute("sendList", sendList);

		return "list";// 해당 뷰
	}

}
