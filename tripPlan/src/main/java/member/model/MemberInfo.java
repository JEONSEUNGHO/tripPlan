package member.model;

import java.sql.Timestamp;
import org.springframework.web.multipart.MultipartFile;

public class MemberInfo {

	private String m_email;
	private String m_pass;
	private String m_pass2;
	private String m_nickname;
	private String m_sex;
	private String m_agerange;
	private Timestamp m_registerdate;
	private String m_profile;
	private MultipartFile uploadImg;
	private int m_identified;
	

	public String getM_pass() {
		return m_pass;
	}
	public void setM_pass(String m_pass) {
		this.m_pass = m_pass;
	}
	public String getM_pass2() {
		return m_pass2;
	}
	public void setM_pass2(String m_pass2) {
		this.m_pass2 = m_pass2;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public String getM_sex() {
		return m_sex;
	}
	public void setM_sex(String m_sex) {
		this.m_sex = m_sex;
	}
	public String getM_agerange() {
		return m_agerange;
	}
	public void setM_agerange(String m_agerange) {
		this.m_agerange = m_agerange;
	}
	public Timestamp getM_registerdate() {
		return m_registerdate;
	}
	public void setM_registerdate(Timestamp m_registerdate) {
		this.m_registerdate = m_registerdate;
	}
	public String getM_profile() {
		return m_profile;
	}
	public void setM_profile(String m_profile) {
		this.m_profile = m_profile;
	}
	public MultipartFile getUploadImg() {
		return uploadImg;
	}
	public void setUploadImg(MultipartFile uploadImg) {
		this.uploadImg = uploadImg;
	}
	public int getM_identified() {
		return m_identified;
	}
	public void setM_identified(int m_identified) {
		this.m_identified = m_identified;
	}



}