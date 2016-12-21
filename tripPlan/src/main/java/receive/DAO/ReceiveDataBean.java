package receive.DAO;

import java.sql.Timestamp;

public class ReceiveDataBean {
	private int rm_id;
	private String rm_title;
	private String rm_contents;
	private Timestamp rm_date;
	private int rm_check;
	private String rm_sender;
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