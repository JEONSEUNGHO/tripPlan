package board.model;

public class ReplyDTO {
	private int re_id;
	private String re_contents;
	private String re_registdate;
	private int b_id;
	private String m_email;
	
	public ReplyDTO() {}
	public ReplyDTO(String re_contents, String re_registdate, int b_id, String m_email) {
		super();
		this.re_contents = re_contents;
		this.re_registdate = re_registdate;
		this.b_id = b_id;
		this.m_email = m_email;
	}
	public int getRe_id() {
		return re_id;
	}
	public void setRe_id(int re_id) {
		this.re_id = re_id;
	}
	public String getRe_contents() {
		return re_contents;
	}
	public void setRe_contents(String re_contents) {
		this.re_contents = re_contents;
	}
	public String getRe_registdate() {
		return re_registdate;
	}
	public void setRe_registdate(String re_registdate) {
		this.re_registdate = re_registdate;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	@Override
	public String toString() {
		return "ReplyDTO [re_id=" + re_id + ", re_contents=" + re_contents + ", re_registdate=" + re_registdate
				+ ", b_id=" + b_id + ", m_email=" + m_email + "]";
	}
	
}
