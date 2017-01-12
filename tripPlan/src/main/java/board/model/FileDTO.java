package board.model;

public class FileDTO {
	private int fi_id;
	private String fi_name;
	private String fi_oname;
	private String fi_path;
	private long fi_size;
	
	public FileDTO(){}
	public FileDTO(String fi_name, String fi_oname, String fi_path, long fi_size) {
		this.fi_name = fi_name;
		this.fi_oname = fi_oname;
		this.fi_path = fi_path;
		this.fi_size = fi_size;
	}
	
	public int getFi_id() {
		return fi_id;
	}
	public void setFi_id(int fi_id) {
		this.fi_id = fi_id;
	}
	public String getFi_name() {
		return fi_name;
	}
	public void setFi_name(String fi_name) {
		this.fi_name = fi_name;
	}
	public String getFi_oname() {
		return fi_oname;
	}
	public void setFi_oname(String fi_oname) {
		this.fi_oname = fi_oname;
	}
	public String getFi_path() {
		return fi_path;
	}
	public void setFi_path(String fi_path) {
		this.fi_path = fi_path;
	}
	public long getFi_size() {
		return fi_size;
	}
	public void setFi_size(long fi_size) {
		this.fi_size = fi_size;
	}
	
	
}
