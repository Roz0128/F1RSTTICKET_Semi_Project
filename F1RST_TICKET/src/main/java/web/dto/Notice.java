package web.dto;

import java.util.Date;

public class Notice {
	
	private int notino;
	private String adminid;
	private String notitype;
	private String notititle;
	private String opendate;
	private String noticontent;
	private int notihit;
	private Date notidate;

	public Notice() {}

	@Override
	public String toString() {
		return "Notice [notino=" + notino + ", adminid=" + adminid + ", notitype=" + notitype + ", notititle="
				+ notititle + ", opendate=" + opendate + ", noticontent=" + noticontent + ", notihit=" + notihit
				+ ", notidate=" + notidate + "]";
	}

	public Notice(int notino, String adminid, String notitype, String notititle, String opendate, String noticontent,
			int notihit, Date notidate) {
		super();
		this.notino = notino;
		this.adminid = adminid;
		this.notitype = notitype;
		this.notititle = notititle;
		this.opendate = opendate;
		this.noticontent = noticontent;
		this.notihit = notihit;
		this.notidate = notidate;
	}

	public int getNotino() {
		return notino;
	}

	public void setNotino(int notino) {
		this.notino = notino;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getNotitype() {
		return notitype;
	}

	public void setNotitype(String notitype) {
		this.notitype = notitype;
	}

	public String getNotititle() {
		return notititle;
	}

	public void setNotititle(String notititle) {
		this.notititle = notititle;
	}

	public String getOpendate() {
		return opendate;
	}

	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}

	public String getNoticontent() {
		return noticontent;
	}

	public void setNoticontent(String noticontent) {
		this.noticontent = noticontent;
	}

	public int getNotihit() {
		return notihit;
	}

	public void setNotihit(int notihit) {
		this.notihit = notihit;
	}

	public Date getNotidate() {
		return notidate;
	}

	public void setNotidate(Date notidate) {
		this.notidate = notidate;
	}
	
}
