<<<<<<< HEAD
package receive.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import receive.model.ReceiveDataBean;
import receive.service.ReceiveService;

@Controller
public class ReceiveController {

	@Autowired
	private ReceiveService service;

	public void setService(ReceiveService service) {
		this.service = service;
	}

	// receive list화면 요청
	@RequestMapping(value = "/receive.do", method = RequestMethod.GET)
	public String view(String pageNum, Model model, HttpServletRequest request) {

		if (pageNum == null) {
			pageNum = "1";
		}
		// 한 페이지의 글의 개수
		int pageSize = 5;
		// 현재 페이지
		int currentPage = Integer.parseInt(pageNum);
		// 한 페이지의 시작글 번호
		int startRow = (currentPage - 1) * pageSize + 1;
		// 한 페이지의 마지막 글번호
		int endRow = currentPage * pageSize;
		// 페이지에 있는 글 개수
		int count = 0;
		String m_email = (String) request.getSession().getAttribute("m_email");

		// list객체 선언
		List<Object> receiveList; 

		count = service.getReceiveCount(m_email);
		if (count > 0) {
			// 현재 페이지에 해당하는 쪽지 수를 리스트에 저장
			receiveList = service.getReceives(startRow, endRow, m_email);
		} else {
			receiveList = Collections.emptyList();
		}
		// 해당 뷰에서 사용할 속성을 모두 model에 저장한다
		model.addAttribute("currentPage", new Integer(currentPage));
		model.addAttribute("startRow", new Integer(startRow));
		model.addAttribute("endRow", new Integer(endRow));
		model.addAttribute("count", new Integer(count));
		model.addAttribute("pageSize", new Integer(pageSize));
		model.addAttribute("receiveList", receiveList);

		return "receive/receive";// 해당 뷰
	}
	
	@RequestMapping(value = "/content.do", method = RequestMethod.GET)
	public String form(int rm_id, String pageNum, Model model) {
		ReceiveDataBean receiveDB = null;
		receiveDB = service.getReceive(rm_id);
		model.addAttribute("receive", receiveDB);
		
		return "receive/receiveForm";
	}

}
=======
package receive.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import receive.service.ReceiveService;

@Controller
public class ReceiveController {

	@Autowired
	private ReceiveService service;

	public void setService(ReceiveService service) {
		this.service = service;
	}

	// receive list화면 요청
	@RequestMapping(value = "/receive.do", method = RequestMethod.GET)
	public String view(String pageNum, Model model, HttpServletRequest request) {
		System.out.println("/receivelist.do요청");

		System.out.println("pageNum: " + pageNum);
		if (pageNum == null) {
			pageNum = "1";
		}
		// 한 페이지의 글의 개수
		int pageSize = 5;
		// 현재 페이지
		int currentPage = Integer.parseInt(pageNum);
		// 한 페이지의 시작글 번호
		int startRow = (currentPage - 1) * pageSize + 1;
		// 한 페이지의 마지막 글번호
		int endRow = currentPage * pageSize;
		// 페이지에 있는 글 개수
		int count = 0;
		String m_email = (String) request.getSession().getAttribute("m_email");

		// list객체 선언
		List<Object> receiveList; 

		count = service.getReceiveCount(m_email);
		if (count > 0) {
			// 현재 페이지에 해당하는 쪽지 수를 리스트에 저장
			receiveList = service.getReceives(startRow, endRow, m_email);
		} else {
			receiveList = Collections.emptyList();
		}

		// number = count - (currentPage - 1) * pageSize; // 글목록에 표시할 글번호
		// 해당 뷰에서 사용할 속성을 모두 model에 저장한다
		model.addAttribute("currentPage", new Integer(currentPage));
		model.addAttribute("startRow", new Integer(startRow));
		model.addAttribute("endRow", new Integer(endRow));
		model.addAttribute("count", new Integer(count));
		model.addAttribute("pageSize", new Integer(pageSize));
		model.addAttribute("receiveList", receiveList);

		return "receive/receive";// 해당 뷰
	}
	@RequestMapping(value = "/receivedel.do")
	public String delete(int rm_id,int[] arry, Model model){
		int check =service.delete(rm_id, arry);
		
		model.addAttribute("check", check);
		
		return "receive/receive";
		
		
		
	}

}
>>>>>>> refs/heads/dohun
