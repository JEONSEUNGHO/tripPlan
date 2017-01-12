package board.model;


public class BoardDTO {
	private int b_id;
	private String b_title;
	private String b_maincontents;
	private String b_mainphoto;
	private int b_favorcount;
	private String b_registertime;
	private String b_startdate;
	private String b_enddate;
	private int b_activity;
	private int b_identified;
	private String m_email;
	private String fi_path;
	
	public BoardDTO(){}
	
	
	
	public BoardDTO(String b_title, String b_maincontents, String b_mainphoto, String b_registertime, String b_startdate,
			String b_enddate, int b_activity, int b_identified, String m_email) {
		super();
		this.b_title = b_title;
		this.b_maincontents = b_maincontents;
		this.b_mainphoto = b_mainphoto;
		this.b_registertime = b_registertime;
		this.b_startdate = b_startdate;
		this.b_enddate = b_enddate;
		this.b_activity = b_activity;
		this.b_identified = b_identified;
		this.m_email = m_email;
	}



	public BoardDTO(String b_title, String b_maincontents, String b_registertime,
			String b_startdate, String b_enddate, int b_activity, int b_identified, String m_email) {
		this.b_title = b_title;
		this.b_maincontents = b_maincontents;
		this.b_registertime = b_registertime;
		this.b_startdate = b_startdate;
		this.b_enddate = b_enddate;
		this.b_activity = b_activity;
		this.b_identified = b_identified;
		this.m_email = m_email;
	}



	public int getB_id() {
		return b_id;
	}



	public void setB_id(int b_id) {
		this.b_id = b_id;
	}



	public String getB_title() {
		return b_title;
	}



	public void setB_title(String b_title) {
		this.b_title = b_title;
	}



	public String getB_maincontents() {
		return b_maincontents;
	}



	public void setB_maincontents(String b_maincontents) {
		this.b_maincontents = b_maincontents;
	}



	public String getB_mainphoto() {
		return b_mainphoto;
	}



	public void setB_mainphoto(String b_mainphoto) {
		this.b_mainphoto = b_mainphoto;
	}



	public int getB_favorcount() {
		return b_favorcount;
	}



	public void setB_favorcount(int b_favorcount) {
		this.b_favorcount = b_favorcount;
	}



	public String getB_registertime() {
		return b_registertime;
	}



	public void setB_registertime(String b_registertime) {
		this.b_registertime = b_registertime;
	}



	public String getB_startdate() {
		return b_startdate;
	}



	public void setB_startdate(String b_startdate) {
		this.b_startdate = b_startdate;
	}



	public String getB_enddate() {
		return b_enddate;
	}



	public void setB_enddate(String b_enddate) {
		this.b_enddate = b_enddate;
	}



	public int getB_activity() {
		return b_activity;
	}



	public void setB_activity(int b_activity) {
		this.b_activity = b_activity;
	}



	public int getB_identified() {
		return b_identified;
	}



	public void setB_identified(int b_identified) {
		this.b_identified = b_identified;
	}



	public String getM_email() {
		return m_email;
	}



	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	


	public String getFi_path() {
		return fi_path;
	}



	public void setFi_path(String fi_path) {
		this.fi_path = fi_path;
	}



	@Override
	public String toString() {
		return "BoardDTO [b_id=" + b_id + ", b_title=" + b_title + ", b_maincontents=" + b_maincontents + ", b_mainphoto="
				+ b_mainphoto + ", b_favorcount=" + b_favorcount + ", b_registertime=" + b_registertime + ", b_startdate="
				+ b_startdate + ", b_enddate=" + b_enddate + ", b_activity=" + b_activity + ", b_identified="
				+ b_identified + ", m_email=" + m_email + "]";
	}
	
	
}
