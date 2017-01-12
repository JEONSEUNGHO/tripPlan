package board.model;

import java.sql.Timestamp;

public class SubBoardDTO {
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
	private int b_id;
	
	public SubBoardDTO() {}
	public SubBoardDTO(String sb_destination, String sb_subtitle, String sb_subcontent, int sb_tcharge, int sb_fcharge,
			int sb_rcharge, String sb_tripdate, String sb_lat, String sb_lon, int sb_procedure, int b_id) {
		super();
		this.sb_destination = sb_destination;
		this.sb_subtitle = sb_subtitle;
		this.sb_subcontent = sb_subcontent;
		this.sb_tcharge = sb_tcharge;
		this.sb_fcharge = sb_fcharge;
		this.sb_rcharge = sb_rcharge;
		this.sb_tripdate = sb_tripdate;
		this.sb_lat = sb_lat;
		this.sb_lon = sb_lon;
		this.sb_procedure = sb_procedure;
		this.b_id = b_id;
	}
	public SubBoardDTO(String sb_destination, String sb_subtitle, String sb_subcontent, int sb_tcharge, int sb_fcharge,
			int sb_rcharge, String sb_tripdate, String sb_photo1, String sb_photo2, String sb_photo3, String sb_photo4,
			String sb_photo5, String sb_lat, String sb_lon, int sb_procedure, int b_id) {
		super();
		this.sb_destination = sb_destination;
		this.sb_subtitle = sb_subtitle;
		this.sb_subcontent = sb_subcontent;
		this.sb_tcharge = sb_tcharge;
		this.sb_fcharge = sb_fcharge;
		this.sb_rcharge = sb_rcharge;
		this.sb_tripdate = sb_tripdate;
		this.sb_photo1 = sb_photo1;
		this.sb_photo2 = sb_photo2;
		this.sb_photo3 = sb_photo3;
		this.sb_photo4 = sb_photo4;
		this.sb_photo5 = sb_photo5;
		this.sb_lat = sb_lat;
		this.sb_lon = sb_lon;
		this.sb_procedure = sb_procedure;
		this.b_id = b_id;
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



	public int getB_id() {
		return b_id;
	}



	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	@Override
	public String toString() {
		return "SubBoardDTO [sb_id=" + sb_id + ", sb_destination=" + sb_destination + ", sb_subtitle=" + sb_subtitle
				+ ", sb_subcontent=" + sb_subcontent + ", sb_tcharge=" + sb_tcharge + ", sb_fcharge=" + sb_fcharge
				+ ", sb_rcharge=" + sb_rcharge + ", sb_tripdate=" + sb_tripdate + ", sb_photo1=" + sb_photo1
				+ ", sb_photo2=" + sb_photo2 + ", sb_photo3=" + sb_photo3 + ", sb_photo4=" + sb_photo4 + ", sb_photo5="
				+ sb_photo5 + ", sb_lat=" + sb_lat + ", sb_lon=" + sb_lon + ", sb_procedure=" + sb_procedure + ", b_id="
				+ b_id + "]";
	}
	
}
