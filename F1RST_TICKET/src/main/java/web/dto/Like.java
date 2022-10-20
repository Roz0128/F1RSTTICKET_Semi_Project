package web.dto;

import java.sql.Connection;

public class Like {

	private int likeno;
	private String userid;
	private int mcno;
	private int likechk;
	
	public Like() {}

	public Like(int likeno, String userid, int mcno, int likechk) {
		super();
		this.likeno = likeno;
		this.userid = userid;
		this.mcno = mcno;
		this.likechk = likechk;
	}

	@Override
	public String toString() {
		return "Like [likeno=" + likeno + ", userid=" + userid + ", mcno=" + mcno + ", likechk=" + likechk + "]";
	}

	public int getLikeno() {
		return likeno;
	}

	public void setLikeno(int likeno) {
		this.likeno = likeno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getMcno() {
		return mcno;
	}

	public void setMcno(int mcno) {
		this.mcno = mcno;
	}

	public int getLikechk() {
		return likechk;
	}

	public void setLikechk(int likechk) {
		this.likechk = likechk;
	}
	
	
	
}
	
