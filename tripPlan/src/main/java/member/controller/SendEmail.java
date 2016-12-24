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
 
	public void generateAndSendEmail(MemberInfo memberInfo,String subject, String content) throws AddressException, MessagingException {
 
		System.out.println("���� ���� ���� �����...");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("���� ���� ��� ����!!");
 
		System.out.println("���� session�� ������...");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		System.out.println(memberInfo.getM_email());
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(memberInfo.getM_email()));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(memberInfo.getM_email()));
		generateMailMessage.setSubject(subject);
		String emailBody = content;
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("���� session ���� ����!!");
 
		System.out.println("session�� �ް� ������ ������ ��...");
		Transport transport = getMailSession.getTransport("smtp");
 
		// �߽��� ���� ��� 
		transport.connect("smtp.gmail.com", "tripplan2017", "mailingtest");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}