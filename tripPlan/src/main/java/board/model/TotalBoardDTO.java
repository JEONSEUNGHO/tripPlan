package board.model;

import java.sql.Timestamp;

public class TotalBoardDTO {
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
	private int sb_id;
	private String sb_destination;
	private String sb_subtitle;
	private String sb_subcontent;
	private int sb_tcharge;
	private int sb_fcharge;
	private int sb_rcharge;
	private String sb_tripdate;
	private String sb_photo1;
	private String sb_photo2;
	private String sb_photo3;
	private String sb_photo4;
	private String sb_photo5;
	private String sb_lat;
	private String sb_lon;
	private int sb_procedure;
	private String m_nickname;
	private String m_sex;
	private String m_agerange;
	private Timestamp m_registerdate;
	private String m_profile;
	
	public TotalBoardDTO() {}

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

	public int getSb_id() {
		return sb_id;
	}

	public void setSb_id(int sb_id) {
		this.sb_id = sb_id;
	}

	public String getSb_destination() {
		return sb_destination;
	}

	public void setSb_destination(String sb_destination) {
		this.sb_destination = sb_destination;
	}

	public String getSb_subtitle() {
		return sb_subtitle;
	}

	public void setSb_subtitle(String sb_subtitle) {
		this.sb_subtitle = sb_subtitle;
	}

	public String getSb_subcontent() {
		return sb_subcontent;
	}

	public void setSb_subcontent(String sb_subcontent) {
		this.sb_subcontent = sb_subcontent;
	}

	public int getSb_tcharge() {
		return sb_tcharge;
	}

	public void setSb_tcharge(int sb_tcharge) {
		this.sb_tcharge = sb_tcharge;
	}

	public int getSb_fcharge() {
		return sb_fcharge;
	}

	public void setSb_fcharge(int sb_fcharge) {
		this.sb_fcharge = sb_fcharge;
	}

	public int getSb_rcharge() {
		return sb_rcharge;
	}

	public void setSb_rcharge(int sb_rcharge) {
		this.sb_rcharge = sb_rcharge;
	}

	public String getSb_tripdate() {
		return sb_tripdate;
	}

	public void setSb_tripdate(String sb_tripdate) {
		this.sb_tripdate = sb_tripdate;
	}

	public String getSb_photo1() {
		return sb_photo1;
	}

	public void setSb_photo1(String sb_photo1) {
		this.sb_photo1 = sb_photo1;
	}

	public String getSb_photo2() {
		return sb_photo2;
	}

	public void setSb_photo2(String sb_photo2) {
		this.sb_photo2 = sb_photo2;
	}

	public String getSb_photo3() {
		return sb_photo3;
	}

	public void setSb_photo3(String sb_photo3) {
		this.sb_photo3 = sb_photo3;
	}

	public String getSb_photo4() {
		return sb_photo4;
	}

	public void setSb_photo4(String sb_photo4) {
		this.sb_photo4 = sb_photo4;
	}

	public String getSb_photo5() {
		return sb_photo5;
	}

	public void setSb_photo5(String sb_photo5) {
		this.sb_photo5 = sb_photo5;
	}

	public String getSb_lat() {
		return sb_lat;
	}

	public void setSb_lat(String sb_lat) {
		this.sb_lat = sb_lat;
	}

	public String getSb_lon() {
		return sb_lon;
	}

	public void setSb_lon(String sb_lon) {
		this.sb_lon = sb_lon;
	}

	public int getSb_procedure() {
		return sb_procedure;
	}

	public void setSb_procedure(int sb_procedure) {
		this.sb_procedure = sb_procedure;
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
	
}