package member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import member.dao.MemberDAO;
import member.model.MemberInfo;
import member.validator.MemberInfoValidator2;

@Controller
public class RegistMemberController2 {

	MemberDAO dao;

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	@ModelAttribute
	protected Object formBackingObject() throws Exception {
		return new MemberInfo();
	}

	@RequestMapping(value = "/mypageload.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute MemberInfo memberInfo, BindingResult result, Model model,
			@RequestParam("uploadImg") MultipartFile uploadImg, HttpServletRequest request, HttpServletResponse response) {
		new MemberInfoValidator2().validate(memberInfo, result);
		// ���� �߻� ��
		if (result.hasErrors()) {
			// ���� �޼��� ó��
			result.reject("errorInfo");

			return "registMemberForm2";
		}

		String check = dao.duplicationCheck(memberInfo);
		if(check != null) {
			return "mypage";
		}

		upload(uploadImg, memberInfo);
		try {
			response.sendRedirect("mypage.do");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "mypage";
	}

	void upload(MultipartFile uploadImg, MemberInfo memberInfo) {
		// ���ϻ���� 0�� ��� (���ε带 ���� �ʾ��� ���) image������ �ӽ������� �������� ����
		if (uploadImg.getSize() != 0.0) {

			File uploadFile = new File(
					"c://images//" + System.currentTimeMillis() + "-" + uploadImg.getOriginalFilename());
			try {
				uploadImg.transferTo(uploadFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			memberInfo.setM_profile(uploadFile.getPath());
			
			int check = dao.insertFile(memberInfo);
			if (check == 0)
				System.out.println("���ε� ����");
		}  
		
		if(memberInfo.getM_profile()==null) {
			memberInfo.setM_profile("");
			int check = dao.insertFile(memberInfo);
			if (check == 0)
				System.out.println("���ε� ����");
		}
	}
}
