package login.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.scribejava.core.model.OAuth2AccessToken;

import login.validator.LoginValidator;
import member.model.MemberInfo;

@Controller
public class LoginController {

	// �α��� Ŭ�� �� ���̹� ����α��� url ���
	private NaverLoginBO naverLoginBO;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	@RequestMapping("/login.do")
	public ModelAndView login(HttpSession session) {
		/* �׾Ʒ� ���� URL�� �����ϱ� ���Ͽ� getAuthorizationUrl�� ȣ�� */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);

		/* ������ ���� URL�� View�� ���� */
		return new ModelAndView("loginForm", "url", naverAuthUrl);
	}

	// �α��� �Ǵ� ȸ������ ���������� ���̹� ����α��� ��� �� ȸ�������� �����ִ� ������
	@RequestMapping("/callback.do")
	public ModelAndView callback(@RequestParam String code, @RequestParam String state, HttpSession session,
			MemberInfo memberInfo) throws IOException {
		OAuth2AccessToken oauthToken = naverLoginBO.getAccessToken(session, code, state);
		String apiResult = naverLoginBO.getUserProfile(oauthToken);
		String m_email = "";
		String m_pass = "";
		String m_sex = "";
		String m_agerange = "";
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParser.parse(apiResult);
			String response = jsonObj.get("response").toString();
			JSONObject jsonValue = (JSONObject) jsonParser.parse(response);

			m_email = jsonValue.get("email").toString();
			m_pass = jsonValue.get("enc_id").toString();
			String[] ages = jsonValue.get("age").toString().split("-");
			m_agerange = ages[0];
			m_sex = jsonValue.get("gender").toString();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		memberInfo.setM_email(m_email);
		memberInfo.setM_pass(m_pass);
		memberInfo.setM_sex(m_sex);
		memberInfo.setM_agerange(m_agerange);
		
		
		return new ModelAndView("registMemberForm2", "memberInfo", memberInfo);
	}

	@ModelAttribute
	protected Object formBackingObject() throws Exception {
		return new MemberInfo();
	}

	@RequestMapping(value = "/loginPro.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute MemberInfo memberInfo, BindingResult result) {
		new LoginValidator().validate(memberInfo, result);
		if (result.hasErrors()) {
			result.reject("errorInfo");
			return "loginForm";
		}
		return "myPage";
	}

}
