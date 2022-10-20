package web.dto;

public class Admin {

	private String adminid;
	private String adminpw;
	
	public Admin() {	}

	public Admin(String adminid, String adminpw) {
		super();
		this.adminid = adminid;
		this.adminpw = adminpw;
	}

	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", adminpw=" + adminpw + "]";
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getAdminpw() {
		return adminpw;
	}

	public void setAdminpw(String adminpw) {
		this.adminpw = adminpw;
	}
	
	
}
