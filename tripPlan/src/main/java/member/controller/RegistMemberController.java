package member.controller;

import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import login.controller.NaverLoginBO;
import member.dao.MemberDAO;
import member.model.MemberInfo;
import member.validator.MemberInfoValidator;
import net.sf.json.JSONObject;

@Controller
public class RegistMemberController {
	
	MemberDAO dao;

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

    //회원가입 클릭 시 네이버 간편로그인 url 등록
    private NaverLoginBO naverLoginBO;

    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO){
        this.naverLoginBO = naverLoginBO;
    }
    // 회원가입 페이지에서 실시간 아이디체크 페이지 요청
	@RequestMapping(value = "/idchk.do", method = RequestMethod.POST)
	public void submit(HttpServletResponse response, HttpServletRequest request) throws Exception {
	      String m_email = request.getParameter("m_email");
	        int flag = -1;
	        String str = "";
	        
			// 이메일 유효성 검사
			Pattern p1 = Pattern.compile("[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}");
			Matcher m1 = p1.matcher(m_email);
			// host 오류 발생 시 
	        if(m_email == null){
	            m_email = "";
	        }        
	        if(!(m_email.equals(""))){
	            flag = dao.realTimeIdchk(m_email);
	        }
	        if(!(m1.find())) { 
	        	flag = -1;
	        }
	        // 유효성 검사
	        if(flag==-1) {
	        	str = "ERROR";
	        }
	        // 이미 존재하는 계정
	        if(flag==1){    
	            str = "NO";
	        }
	        // 사용가능한 계정
	        if(flag==0){        
	            str = "YES";
	        } 
		JSONObject jso = new JSONObject(); // JASON 객체생성
		jso.put("data", str); // jason은 map구조(키,값), data라는 key로 list데이터를 주입했다.

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jso.toString()); // out.print 내용을 ajax의 dataType이 jason에게 데이터 쏴줌
	}
 
    // 헤더에서 회원가입 버튼 클릭 시 
    @RequestMapping("/regist.do")
    public ModelAndView login(HttpSession session, MemberInfo memberInfo) {
        /* 네아로 인증 URL을 생성하기 위하여 getAuthorizationUrl을 호출 */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        if(memberInfo.getM_email() != null) {
        	new MemberInfo();
        }
        
        /* 생성한 인증 URL을 View로 전달 */
        return new ModelAndView("registMemberForm", "url", naverAuthUrl);
    }


	@ModelAttribute
	protected Object formBackingObject() throws Exception {
		return new MemberInfo();

	}
	// 회원가입1에서 다음 버튼 클릭 시 
	@RequestMapping(value = "/regist.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute MemberInfo memberInfo, BindingResult result, Model model, HttpSession session) {
		new MemberInfoValidator().validate(memberInfo, result);
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		if (result.hasErrors()) {
			result.reject("errorInfo");
			model.addAttribute("url", naverAuthUrl);
			return "registMemberForm";
		}
		return "registMemberForm2";
	}

}
