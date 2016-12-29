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

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;

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
	// 회원가입 2 에서 가입 버튼 클릭 시 
	@RequestMapping(value = "/mypageload.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute MemberInfo memberInfo, BindingResult result, Model model,
			@RequestParam("uploadImg") MultipartFile uploadImg, HttpServletRequest request, HttpServletResponse response) {
		new MemberInfoValidator2().validate(memberInfo, result);
		// 에러 발생 시
		if (result.hasErrors()) {
			// 에러 메세지 처리
			result.reject("errorInfo");

			return "registMemberForm2";
		}
		// DB에 해당 이메일이 존재할 시 
		String check = dao.duplicationCheck(memberInfo);
		if(check == null) {
			check = "";
		} else if(check != null) {
			try {
				response.sendRedirect("mypage.do");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "mypage";
		} 
		
		upload(uploadImg, memberInfo);
		request.getSession().setAttribute("m_email", memberInfo.getM_email());
		try {
			
			response.sendRedirect("mypage.do");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "mypage";
	}

	void upload(MultipartFile uploadImg, MemberInfo memberInfo) {
		// 파일사이즈가 0일 경우 (업로드를 하지 않았을 경우) image폴더에 임시파일을 생성하지 않음
		if (uploadImg.getSize() != 0.0) {

			File uploadFile = new File("c:\\images\\"+System.currentTimeMillis()+uploadImg.getOriginalFilename());
			String m_profile = "http://s3.amazonaws.com/tripplan2017/profileImg/"+uploadFile.getName();
			memberInfo.setM_profile(m_profile);
			try {
				uploadImg.transferTo(uploadFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				uploadAWS(uploadFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int check = dao.insertFile(memberInfo);
			if (check == 0)
				System.out.println("업로드 실패");
		}  
		
		if(memberInfo.getM_profile()==null) {
			memberInfo.setM_profile("");
			int check = dao.insertFile(memberInfo);
			if (check == 0)
				System.out.println("업로드 실패");
		}
		
	}
	
	// AmazonWebServer에 이미지 upload
	public void uploadAWS(File file) throws IOException {
        String bucketName = "tripplan2017/profileImg";
        // 여기서, accessKey와 secretKey를 설정하고 있음
        AWSCredentials credentials = null;
        try {
            credentials = new ProfileCredentialsProvider().getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (~/.aws/credentials), and is in valid format.",
                    e);
        }

        AmazonS3 s3 = new AmazonS3Client(credentials);
        s3.putObject(new PutObjectRequest(bucketName, file.getName(), file));
        System.out.println("AWS upload OK");
	}
	
}
