package web.dto;

import java.util.Date;

public class ReviewFile {

	private int fileno;
	private int reviewno;
	private String originname;
	private String storedname;
	private int filesize;
	private Date writedate;
	
	public ReviewFile() {}

	@Override
	public String toString() {
		return "ReviewFile [fileno=" + fileno + ", reviewno=" + reviewno + ", originname=" + originname
				+ ", storedname=" + storedname + ", filesize=" + filesize + ", writedate=" + writedate + "]";
	}

	public ReviewFile(int fileno, int reviewno, String originname, String storedname, int filesize, Date writedate) {
		super();
		this.fileno = fileno;
		this.reviewno = reviewno;
		this.originname = originname;
		this.storedname = storedname;
		this.filesize = filesize;
		this.writedate = writedate;
	}

	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public int getReviewno() {
		return reviewno;
	}

	public void setReviewno(int reviewno) {
		this.reviewno = reviewno;
	}

	public String getOriginname() {
		return originname;
	}

	public void setOriginname(String originname) {
		this.originname = originname;
	}

	public String getStoredname() {
		return storedname;
	}

	public void setStoredname(String storedname) {
		this.storedname = storedname;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	
}
