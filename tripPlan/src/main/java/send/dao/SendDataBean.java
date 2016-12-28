package send.dao;

import java.sql.Timestamp;

public class SendDataBean {
	private int sm_id;
	private String sm_title;
	private String sm_contents;
	private Timestamp sm_date;
	private int sm_check;
	private String sm_receiver;
	private String m_email;
	
	public int getSm_id() {
		return sm_id;
	}
	public void setSm_id(int sm_id) {
		this.sm_id = sm_id;
	}
	public String getSm_title() {
		return sm_title;
	}
	public void setSm_title(String sm_title) {
		this.sm_title = sm_title;
	}
	public String getSm_contents() {
		return sm_contents;
	}
	public void setSm_contents(String sm_contents) {
		this.sm_contents = sm_contents;
	}
	public Timestamp getSm_date() {
		return sm_date;
	}
	public void setSm_date(Timestamp sm_date) {
		this.sm_date = sm_date;
	}
	public int getSm_check() {
		return sm_check;
	}
	public void setSm_check(int sm_check) {
		this.sm_check = sm_check;
	}
	public String getSm_receiver() {
		return sm_receiver;
	}
	public void setSm_receiver(String sm_receiver) {
		this.sm_receiver = sm_receiver;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

}

