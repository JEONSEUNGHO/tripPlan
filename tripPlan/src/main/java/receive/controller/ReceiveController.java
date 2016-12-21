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
	private ReceiveService service; // CityServiceImpl객체를 받아온다. CityService
									// interface이므로

	public void setService(ReceiveService service) {
		this.service = service;
	}
	@RequestMapping(value = "/list.do")
	public String rcr(String pageNum, String search,@RequestParam(defaultValue="0") int searchn, Model model) throws Throwable {

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

		count = service.getReceiveCount(search, searchn );

		if (count > 0) {
			receiveList = service.getReceives(startRow, endRow,search, searchn);// 현재 페이지에 해당하는													// 글 목록
		} else {
			receiveList = Collections.EMPTY_LIST;
		}

		number = count - (currentPage - 1) * pageSize;// 글목록에 표시할 글번호
		// 해당 뷰에서 사용할 속성
		model.addAttribute("currentPage", new Integer(currentPage));
		model.addAttribute("startRow", new Integer(startRow));
		model.addAttribute("endRow", new Integer(endRow));
		model.addAttribute("count", new Integer(count));
		model.addAttribute("pageSize", new Integer(pageSize));
		model.addAttribute("number", new Integer(number));
		model.addAttribute("receiveList", receiveList);

		return "list";// 해당 뷰
	}
	

}
