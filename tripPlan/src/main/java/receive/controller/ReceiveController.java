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

	// receive listȭ�� ��û
	@RequestMapping(value = "/receive.do", method = RequestMethod.GET)
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
		String m_email = (String) request.getSession().getAttribute("m_email");

		// list��ü ����
		List<Object> receiveList; 

		count = service.getReceiveCount(m_email);
		if (count > 0) {
			// ���� �������� �ش��ϴ� ���� ���� ����Ʈ�� ����
			receiveList = service.getReceives(startRow, endRow, m_email);
		} else {
			receiveList = Collections.emptyList();
		}
		// �ش� �信�� ����� �Ӽ��� ��� model�� �����Ѵ�
		model.addAttribute("currentPage", new Integer(currentPage));
		model.addAttribute("startRow", new Integer(startRow));
		model.addAttribute("endRow", new Integer(endRow));
		model.addAttribute("count", new Integer(count));
		model.addAttribute("pageSize", new Integer(pageSize));
		model.addAttribute("receiveList", receiveList);

		return "receive/receive";// �ش� ��
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

	// receive listȭ�� ��û
	@RequestMapping(value = "/receive.do", method = RequestMethod.GET)
	public String view(String pageNum, Model model, HttpServletRequest request) {
		System.out.println("/receivelist.do��û");

		System.out.println("pageNum: " + pageNum);
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
		String m_email = (String) request.getSession().getAttribute("m_email");

		// list��ü ����
		List<Object> receiveList; 

		count = service.getReceiveCount(m_email);
		if (count > 0) {
			// ���� �������� �ش��ϴ� ���� ���� ����Ʈ�� ����
			receiveList = service.getReceives(startRow, endRow, m_email);
		} else {
			receiveList = Collections.emptyList();
		}

		// number = count - (currentPage - 1) * pageSize; // �۸�Ͽ� ǥ���� �۹�ȣ
		// �ش� �信�� ����� �Ӽ��� ��� model�� �����Ѵ�
		model.addAttribute("currentPage", new Integer(currentPage));
		model.addAttribute("startRow", new Integer(startRow));
		model.addAttribute("endRow", new Integer(endRow));
		model.addAttribute("count", new Integer(count));
		model.addAttribute("pageSize", new Integer(pageSize));
		model.addAttribute("receiveList", receiveList);

		return "receive/receive";// �ش� ��
	}
	@RequestMapping(value = "/receivedel.do")
	public String delete(int rm_id,int[] arry, Model model){
		int check =service.delete(rm_id, arry);
		
		model.addAttribute("check", check);
		
		return "receive/receive";
		
		
		
	}

}
>>>>>>> refs/heads/dohun
