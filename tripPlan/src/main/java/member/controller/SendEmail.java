package member.controller;
 
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;

import member.model.MemberInfo;
 
/**
 * @author Crunchify.com
 * 
 */
 @Controller
public class SendEmail {
 
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
 
	public void generateAndSendEmail(MemberInfo memberInfo) throws AddressException, MessagingException {
 
		System.out.println("메일 서버 정보 등록중...");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("메일 서버 등록 성공!!");
 
		System.out.println("메일 session을 생성중...");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		System.out.println(memberInfo.getM_email());
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(memberInfo.getM_email()));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(memberInfo.getM_email()));
		generateMailMessage.setSubject("triP plan 회원가입 인증메일 입니다.");
		String emailBody = "Please click on the link below for verification " + 
		"<br><br> <a href=http://localhost:8088/tripPlan/tiles/mypage.do?authkey=1>verify</a>";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("메일 session 생성 성공!!");
 
		System.out.println("session을 받고 메일을 보내는 중...");
		Transport transport = getMailSession.getTransport("smtp");
 
		// 발신자 정보 등록 
		transport.connect("smtp.gmail.com", "tripplan2017", "mailingtest");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}