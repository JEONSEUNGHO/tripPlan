package receive.DAO;

import java.sql.Timestamp;

public class ReceiveDataBean {
	private int rm_id;
	private String rm_title;
	private String rm_content;
	private Timestamp rm_date;
	private int rm_check;
	private int rm_sender;

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

	public String getRm_content() {
		return rm_content;
	}

	public void setRm_content(String rm_content) {
		this.rm_content = rm_content;
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

	public int getRm_sender() {
		return rm_sender;
	}

	public void setRm_sender(int rm_sender) {
		this.rm_sender = rm_sender;
	}

}
