package board.model;

import java.sql.Timestamp;

public class BoardDTO {
	private int b_id;
	private String b_title;
	private String b_maincontents;
	private String b_mainphoto;
	private int b_favorcount;
	private String b_registertime;
	private int b_totalprice;
	private String b_totalspendtime;
	private int b_identified;
	private String m_email;
	
	public BoardDTO(){}
	
	public BoardDTO(String b_title, String b_maincontents, String b_mainphoto, int b_favorcount, String b_registertime,
			int b_totalprice, String b_totalspendtime, int b_identified, String m_email) {
		this.b_title = b_title;
		this.b_maincontents = b_maincontents;
		this.b_mainphoto = b_mainphoto;
		this.b_favorcount = b_favorcount;
		this.b_registertime = b_registertime;
		this.b_totalprice = b_totalprice;
		this.b_totalspendtime = b_totalspendtime;
		this.b_identified = b_identified;
		this.m_email = m_email;
	}

	public BoardDTO(int b_id, String b_title, String b_maincontents, String b_mainphoto, int b_favorcount,
			int b_totalprice, String b_totalspendtime, int b_identified, String m_email) {
		this.b_id = b_id;
		this.b_title = b_title;
		this.b_maincontents = b_maincontents;
		this.b_mainphoto = b_mainphoto;
		this.b_favorcount = b_favorcount;
		this.b_totalprice = b_totalprice;
		this.b_totalspendtime = b_totalspendtime;
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
	public int getB_totalprice() {
		return b_totalprice;
	}
	public void setB_totalprice(int b_totalprice) {
		this.b_totalprice = b_totalprice;
	}
	public String getB_totalspendtime() {
		return b_totalspendtime;
	}
	public void setB_totalspendtime(String b_totalspendtime) {
		this.b_totalspendtime = b_totalspendtime;
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
	
	public String getB_registertime() {
		return b_registertime;
	}

	public void setB_registertime(String b_registertime) {
		this.b_registertime = b_registertime;
	}

	@Override
	public String toString() {
		return "b_title : "+b_title+" b_maincontents : "+b_maincontents+" b_mainphoto : "+b_mainphoto+" b_favorcount : "+b_favorcount
				+" b_totalprice : "+b_totalprice+" b_totalspendtime : "+b_totalspendtime+" b_identified : "+b_identified+" m_email : "+m_email;
	}
}
