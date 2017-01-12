package send.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import send.dao.SendDataBean;
import send.service.SendService;

@Controller
public class SendListController {
	@Autowired
	private SendService service;
	
	public void setService(SendService service) {
		this.service = service;
	}
	// receive list화면 요청
		@RequestMapping(value = "/send.do", method = RequestMethod.GET)
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
			int receive_count = 0;
			String m_email = (String) request.getSession().getAttribute("m_email");

			// list객체 선언
			List<Object> sendList; 
			receive_count = service.getReceiveCount(m_email);
			count = service.getSendCount(m_email);
			if (count > 0) {
				// 현재 페이지에 해당하는 쪽지 수를 리스트에 저장
				sendList = service.getSends(startRow, endRow, m_email);
			} else {
				sendList = Collections.emptyList();
			}
			// 해당 뷰에서 사용할 속성을 모두 model에 저장한다
			model.addAttribute("currentPage", new Integer(currentPage));
			model.addAttribute("startRow", new Integer(startRow));
			model.addAttribute("endRow", new Integer(endRow));
			model.addAttribute("count", new Integer(count));
			model.addAttribute("r_count", new Integer(receive_count));
			model.addAttribute("pageSize", new Integer(pageSize));
			model.addAttribute("sendList", sendList);

			return "send/send";// 해당 뷰
		}
		
		@RequestMapping(value = "/senddelete.do", method = RequestMethod.POST)
		public void submit(SendDataBean sendDB, HttpServletRequest request, HttpServletResponse response) {
			// session 값에서 아이디 가져오기 
			String m_email = (String) request.getSession().getAttribute("m_email");
			sendDB.setM_email(m_email);
			service.senddelete(sendDB);
			try {
				response.sendRedirect("send.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

}
