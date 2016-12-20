package member.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import member.dao.MemberDAO;
import member.model.Code;
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

	private void referenceData(Model model) {
		List<Code> ageCodes = new ArrayList<Code>();
		ageCodes.add(new Code("10대", "10대"));
		ageCodes.add(new Code("20대", "20대"));
		ageCodes.add(new Code("30대", "30대"));
		ageCodes.add(new Code("40대", "40대"));
		ageCodes.add(new Code("50대 이상", "50대 이상"));

		model.addAttribute("m_agerange", ageCodes);

	}

	@RequestMapping(value = "/mypage.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute MemberInfo memberInfo, BindingResult result, Model model,
			@RequestParam("uploadImg") MultipartFile uploadImg) {
		System.out.println(memberInfo.getM_email());
		System.out.println(memberInfo.getM_pass());
		new MemberInfoValidator2().validate(memberInfo, result);
	
		// 오류 발생 시 에러 메세지 처리
		if (result.hasErrors()) {

			result.reject("errorInfo");
			referenceData(model);
			return "registMemberForm2";
		}

		upload(uploadImg, memberInfo);

		
		return "myPage";
	}

	void upload(MultipartFile uploadImg, MemberInfo memberInfo) {
		// 파일사이즈가 0일 경우 (업로드를 하지 않았을 경우) image폴더에 임시파일을 생성하지 않음
		if (uploadImg.getSize() != 0.0) {
			
				File uploadFile = new File(
						"c://file//" + System.currentTimeMillis() + "-" + uploadImg.getOriginalFilename());
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
				System.out.println("업로드 실패");
		}
	}
}
