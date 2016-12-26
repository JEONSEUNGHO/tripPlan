package member.controller;


import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.dao.MemberDAO;
import member.model.MemberInfo;
import member.validator.FindpwValidator;


@Controller
public class FindpwController {
	
	@Autowired
	SendEmail sendemail;

	public void setSendemail(SendEmail sendemail) {
		this.sendemail = sendemail;
	}
	
	MemberDAO dao;

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/findpw.do", method = RequestMethod.GET)
	public String form() {
		return "findpw";
	}
	
	@ModelAttribute
	protected Object formBackingObject() throws Exception {
		return new MemberInfo();
	}
	
	@RequestMapping(value = "/findpw.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute MemberInfo memberInfo, BindingResult result) {
		new FindpwValidator().validate(memberInfo, result);
		if (result.hasErrors()) {
			result.reject("errorInfo");
			return "findpw";
		}
		// DB�� �ش� �̸����� ���� �� 
		String check = dao.duplicationCheck(memberInfo);
		if(check == null) {
			// ���� �޼��� ó��
			result.reject("idNotFound");
			return "findpw";
		}
		// DB�� �ش� �̸����� ����
		char[] tempPWArray = new char[8];
		// ���� �ҹ��� ����
		tempPWArray[0] = (char)(((Math.random())*25)+97);
		// ���� ����
		tempPWArray[1] = (char)(((Math.random())*9)+48);
		tempPWArray[2] = (char)(((Math.random())*25)+97);
		tempPWArray[3] = (char)(((Math.random())*25)+97);
		// Ư������ ����
		tempPWArray[4] = (char)(((Math.random())*14)+33);
		tempPWArray[5] = (char)(((Math.random())*25)+97);
		// ���� ����
		tempPWArray[6] = (char)(((Math.random())*9)+48);
		tempPWArray[7] = (char)(((Math.random())*25)+97);
		// char[]�� String���� ��ȯ
		String tempPW = new String(tempPWArray, 0, tempPWArray.length);
	
		String subject = "triP plan ��й�ȣ ��û �����Դϴ�.";
		String content = "This is your temporary password. <br><br>"+tempPW+"<br><br> Please change your password after sign in";
		try {
			sendemail.generateAndSendEmail(memberInfo, subject, content);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("��й�ȣ ��û �̸��� ���ۿϷ�!!");
		memberInfo.setTempPW(tempPW);
		dao.updatePW(memberInfo);
		return "mypagewait";
	}

}
