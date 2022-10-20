package web.dto;

public class User {
	
	private String username;
	private String userid;
	private String userpw;
	private String gender;
	private String userbirth;
	private String uphone;
	private String address;
	private String email;
	
	public User() {	}

	public User(String username, String userid, String userpw, String gender, String userbirth, String uphone,
			String address, String email) {
		super();
		this.username = username;
		this.userid = userid;
		this.userpw = userpw;
		this.gender = gender;
		this.userbirth = userbirth;
		this.uphone = uphone;
		this.address = address;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", userid=" + userid + ", userpw=" + userpw + ", gender=" + gender
				+ ", userbirth=" + userbirth + ", uphone=" + uphone + ", address=" + address + ", email=" + email + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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
