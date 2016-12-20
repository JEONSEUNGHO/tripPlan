package send.DAO;

import java.sql.Timestamp;

public class SendDataBean {
	private int sm_id;
	private String sm_title;
	private String sm_content;
	private Timestamp sm_date;
	private int sm_check;
	private int sm_receiver;

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

	public String getSm_content() {
		return sm_content;
	}

	public void setSm_content(String sm_content) {
		this.sm_content = sm_content;
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

	public int getSm_receiver() {
		return sm_receiver;
	}

	public void setSm_receiver(int sm_receiver) {
		this.sm_receiver = sm_receiver;
	}

}
