package web.dto;

public class UserBoard {

	private String userid;
	private String username;
	private String userpw;
	private String gender;
	private String userbirth;
	private String uphone;
	private String address;
	private String email;
	
	public UserBoard() {	}

	public UserBoard(String userid, String username, String userpw, String gender, String userbirth,
			String uphone, String address, String email) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpw = userpw;
		this.gender = gender;
		this.userbirth = userbirth;
		this.uphone = uphone;
		this.address = address;
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserBoard [userid=" + userid + ", username=" + username + ", userpw=" + userpw
				+ ", gender=" + gender + ", userbirth=" + userbirth + ", uphone=" + uphone + ", address=" + address
				+ ", email=" + email + "]";
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserbirth() {
		return userbirth;
	}

	public void setUserbirth(String userbirth) {
		this.userbirth = userbirth;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
