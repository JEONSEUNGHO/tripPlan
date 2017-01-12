package mypage.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;

import member.model.MemberInfo;
import mypage.dao.MypageDAO;

@Controller
public class ProfileController {

	@Autowired
	private MypageDAO dao;

	public void setDao(MypageDAO dao) {
		this.dao = dao;
	}


	@RequestMapping(value = "/profile.do", method = RequestMethod.POST)
	public String submit(@RequestParam("uploadImg") MultipartFile uploadImg, MemberInfo memberInfo, Model model, HttpServletRequest request, HttpServletResponse response) {
		// Session�� ����� �̸����� �����´� 
		String m_email = (String) request.getSession().getAttribute("m_email");
		memberInfo.setM_email(m_email);
		// ���ϻ���� 0�� ��� (���ε带 ���� �ʾ��� ���) image������ �ӽ������� �������� ����
		if (uploadImg.getSize() != 0.0) {
	
		    
			File uploadFile = new File("c:\\images\\"+System.currentTimeMillis()+uploadImg.getOriginalFilename());
			if(!uploadFile.isDirectory()){
				uploadFile.mkdirs();
		      }
			String m_profile = "http://s3.amazonaws.com/tripplan2017/profileImg/"+uploadFile.getName();
			memberInfo.setM_profile(m_profile);
			try {
				uploadImg.transferTo(uploadFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} try {
				uploadAWS(uploadFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			int check = dao.updateProfile(memberInfo);
			model.addAttribute("check", check);
			
			if (check == 0)
				System.out.println("���ε� ����");
			return "redirect:/tiles/mypage.do?check="+check;
			
		} else if(uploadImg.getSize() == 0.0) {
			String m_profile = (String) request.getSession().getAttribute("m_profile");
			if(m_profile == null) {
				m_profile = "";
			}
			memberInfo.setM_profile(m_profile);
			int check = dao.updateProfile(memberInfo);
			model.addAttribute("check", check);
			
			if (check == 0) 
				System.out.println("���ε� ����");
			return "redirect:/tiles/mypage.do?check="+check;
		}
 
		return "mypage";
	}
	
	// AmazonWebServer�� �̹��� upload (��� Ŭ���������� �ø� �� �ְ� static���� ����)
	public static void uploadAWS(File file) throws IOException {
        String bucketName = "tripplan2017/profileImg";
        // accessKey�� secretKey�� ���
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAISKDAQ7YRVLCDNAA", "wLNQEmjYXsshTWzn3fwmi5kLhUilNUSXolvvttET");
        	
        // AWS��ü�� �����ϰ� config���� (key, regions)�� ���
        AmazonS3 s3 = new AmazonS3Client(credentials).withRegion(Regions.US_EAST_1);
        // ������ ��ü�� AWS�� ��� 
        s3.putObject(new PutObjectRequest(bucketName, file.getName(), file));
        System.out.println("AWS upload OK");
	}
}
