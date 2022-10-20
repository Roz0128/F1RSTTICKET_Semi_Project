package web.dto;

import java.util.Date;

public class Comment {
	
	private int cmno;
	private String userid;
	private int reviewno;
	private String content;
	private Date writedate;
	
	public Comment() {}

	@Override
	public String toString() {
		return "Comment [cmno=" + cmno + ", userid=" + userid + ", reviewno=" + reviewno + ", content=" + content
				+ ", writedate=" + writedate + "]";
	}

	public Comment(int cmno, String userid, int reviewno, String content, Date writedate) {
		super();
		this.cmno = cmno;
		this.userid = userid;
		this.reviewno = reviewno;
		this.content = content;
		this.writedate = writedate;
	}

	public int getCmno() {
		return cmno;
	}

	public void setCmno(int cmno) {
		this.cmno = cmno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getReviewno() {
		return reviewno;
	}

	public void setReviewno(int reviewno) {
		this.reviewno = reviewno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

}
