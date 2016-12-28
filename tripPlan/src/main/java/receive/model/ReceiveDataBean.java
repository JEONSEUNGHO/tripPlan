<<<<<<< HEAD
package receive.model;

import java.sql.Timestamp;

public class ReceiveDataBean {
	// 받은 목록 번호
	private int rm_id;
	// 받은 쪽지 제목
	private String rm_title;
	// 받은 쪽지 내용
	private String rm_contents;
	// 받은 쪽지 시간 
	private Timestamp rm_date;
	// 수신 확인 미확인 : 0 확인 : 1
	private int rm_check;
	// 보낸사람 
	private String rm_sender;
	// 받은사람
	private String m_email;
	
	
	public int getRm_id() {
		return rm_id;
	}
	public void setRm_id(int rm_id) {
		this.rm_id = rm_id;
	}
	public String getRm_title() {
		return rm_title;
	}
	public void setRm_title(String rm_title) {
		this.rm_title = rm_title;
	}
	public String getRm_contents() {
		return rm_contents;
	}
	public void setRm_contents(String rm_contents) {
		this.rm_contents = rm_contents;
	}
	public Timestamp getRm_date() {
		return rm_date;
	}
	public void setRm_date(Timestamp rm_date) {
		this.rm_date = rm_date;
	}
	public int getRm_check() {
		return rm_check;
	}
	public void setRm_check(int rm_check) {
		this.rm_check = rm_check;
	}
	public String getRm_sender() {
		return rm_sender;
	}
	public void setRm_sender(String rm_sender) {
		this.rm_sender = rm_sender;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	


}

=======
package receive.model;

import java.sql.Timestamp;

public class ReceiveDataBean {
	// 받은 목록 번호
	private int[] rm_id;
	// 받은 쪽지 제목
	private String rm_title;
	// 받은 쪽지 내용
	private String rm_contents;
	// 받은 쪽지 시간 
	private Timestamp rm_date;
	// 수신 확인 미확인 : 0 확인 : 1
	private int rm_check;
	// 보낸사람 
	private String rm_sender;
	// 받은사람
	private String m_email;
	
	
	public int[] getRm_id() {
		return rm_id;
	}
	public void setRm_id(int[] rm_id) {
		this.rm_id = rm_id;
	}
	public String getRm_title() {
		return rm_title;
	}
	public void setRm_title(String rm_title) {
		this.rm_title = rm_title;
	}
	public String getRm_contents() {
		return rm_contents;
	}
	public void setRm_contents(String rm_contents) {
		this.rm_contents = rm_contents;
	}
	public Timestamp getRm_date() {
		return rm_date;
	}
	public void setRm_date(Timestamp rm_date) {
		this.rm_date = rm_date;
	}
	public int getRm_check() {
		return rm_check;
	}
	public void setRm_check(int rm_check) {
		this.rm_check = rm_check;
	}
	public String getRm_sender() {
		return rm_sender;
	}
	public void setRm_sender(String rm_sender) {
		this.rm_sender = rm_sender;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	


}

>>>>>>> refs/heads/dohun
