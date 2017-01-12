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
	// receive listȭ�� ��û
		@RequestMapping(value = "/send.do", method = RequestMethod.GET)
		public String view(String pageNum, Model model, HttpServletRequest request) {

			if (pageNum == null) {
				pageNum = "1";
			}
			// �� �������� ���� ����
			int pageSize = 5;
			// ���� ������
			int currentPage = Integer.parseInt(pageNum);
			// �� �������� ���۱� ��ȣ
			int startRow = (currentPage - 1) * pageSize + 1;
			// �� �������� ������ �۹�ȣ
			int endRow = currentPage * pageSize;
			// �������� �ִ� �� ����
			int count = 0;
			int receive_count = 0;
			String m_email = (String) request.getSession().getAttribute("m_email");

			// list��ü ����
			List<Object> sendList; 
			receive_count = service.getReceiveCount(m_email);
			count = service.getSendCount(m_email);
			if (count > 0) {
				// ���� �������� �ش��ϴ� ���� ���� ����Ʈ�� ����
				sendList = service.getSends(startRow, endRow, m_email);
			} else {
				sendList = Collections.emptyList();
			}
			// �ش� �信�� ����� �Ӽ��� ��� model�� �����Ѵ�
			model.addAttribute("currentPage", new Integer(currentPage));
			model.addAttribute("startRow", new Integer(startRow));
			model.addAttribute("endRow", new Integer(endRow));
			model.addAttribute("count", new Integer(count));
			model.addAttribute("r_count", new Integer(receive_count));
			model.addAttribute("pageSize", new Integer(pageSize));
			model.addAttribute("sendList", sendList);

			return "send/send";// �ش� ��
		}
		
		@RequestMapping(value = "/senddelete.do", method = RequestMethod.POST)
		public void submit(SendDataBean sendDB, HttpServletRequest request, HttpServletResponse response) {
			// session ������ ���̵� �������� 
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
