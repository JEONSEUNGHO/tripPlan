package login.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class naverLoginController {

	@RequestMapping(value = "/naverLogin.do", method = RequestMethod.GET)
	public void form(HttpServletRequest request, HttpServletResponse response) {
		
		// ���� ��ū���� ����� ���� ���ڿ� ����
		String state = generateState();
		String uri = "https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=cs7UbuHSeDW9o9VD7D6_&scope=login+userinfo&state="+state+"&redirect_uri=http://localhost:8088/tripPlan/tiles/callback.do"; 
		System.out.println(state);
		// ���� �Ǵ� ������ ���� ������ ���� ��ū�� ����		
		try {
			response.sendRedirect(uri);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String generateState() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}
	
	@RequestMapping(value = "/callback.do")
	public String form2() {
		return "callback";
	}
}
