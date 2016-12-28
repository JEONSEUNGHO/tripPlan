package send.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.json.JSONObject;
import send.dao.SendDataBean;
import send.service.SendService;
import send.validator.SendValidator;

@Controller
public class SendController {

	@Autowired
	private SendService service;

	public void setService(SendService service) {
		this.service = service;
	}

	@RequestMapping(value = "/sendwrite.do", method = RequestMethod.GET)
	public String sendwrite() {
		return "send/sendwrite";
	}

	@RequestMapping(value = "/sendwritePro.do", method = RequestMethod.POST)
	public String writePro(@ModelAttribute SendDataBean send, BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {
		new SendValidator().validate(send, result);
		// ��ȿ�� �˻� ���� �߻� ��
		if (result.hasErrors()) {
			return "send/sendwrite";
		}
		send.setM_email((String) (request.getSession().getAttribute("m_email")));
		service.insert(send);
		try {
			response.sendRedirect("send.do");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "send/send";
	}

	@ModelAttribute
	protected SendDataBean formBack() throws Exception {
		return new SendDataBean();

	}

	// ���� ���� Ŭ�� �� ��û ó��
	@RequestMapping(value = "/sendcontent.do", method = RequestMethod.GET)
	public String form(int sm_id, String pageNum, Model model) {
		SendDataBean sendDB = null;
		sendDB = service.getSend(sm_id);
		model.addAttribute("send", sendDB);

		return "send/sendForm";
	}

	// �ǽð� ���̵�üũ ������ ��û

	@RequestMapping(value = "/idchk2.do", method = RequestMethod.POST)
	public void submit(HttpServletResponse response, HttpServletRequest request) throws Exception {
		String sm_receiver = request.getParameter("sm_receiver");
		int flag = -1;
		String str = "";

		if (sm_receiver.trim().isEmpty()) {
			str = "ERROR";
		}
		if (!(sm_receiver.equals(""))) {
			flag = service.realTimeIdchk2(sm_receiver);
		}

		// �����ϴ� ����
		if (flag == 1) {
			str = "YES";
		}
		// ���� ����
		if (flag == 0) {
			str = "NO";
		}

		JSONObject jso = new JSONObject(); // JASON ��ü����
		jso.put("data", str); // jason�� map����(Ű,��), data��� key�� list�����͸� �����ߴ�.

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jso.toString()); // out.print
									// ������
									// ajax��dataType�� jason���Ե����� ����
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/idchk.do")
	public void submit2(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setCharacterEncoding("utf-8");
		String searchValue = request.getParameter("searchValue");
		JSONArray arrayObj = new JSONArray();
		JSONObject jsonObj = null;

		ArrayList<String> dblist = (ArrayList<String>) service.realTimeIdchk();
		ArrayList<String> resultlist = new ArrayList<String>();

		// DB���� ������ ������
		for (String str : dblist) {
			if (str.toLowerCase().startsWith(searchValue) || str.toLowerCase().endsWith(searchValue) || str.indexOf(searchValue)>=1) {
				resultlist.add(str);
			}
		}
		// ���� �� json�Ľ�
		for (String str : resultlist) {
			jsonObj = new JSONObject();
			jsonObj.put("data", str);
			arrayObj.add(jsonObj);
		}

		PrintWriter pw = response.getWriter();
		pw.print(arrayObj);
		pw.flush();
		pw.close();
	}

}
