package web.dto;

public class Musical {
	private int mcno;
	private String mcname;
	private String mcage;
	private String mctime;
	private String mcstart;
	private String mcend;
	private String mcact;
	private String mcloc;
	private int mclike;
	private String mcimg;
	private String mcimgcas;
	private String mcimginfo;
	private String mcimgchk;
	private String mcimgsale;
	
	public Musical() {}

	public Musical(int mcno, String mcname, String mcage, String mctime, String mcstart, String mcend, String mcact,
			String mcloc, int mclike, String mcimg, String mcimgcas, String mcimginfo, String mcimgchk,
			String mcimgsale) {
		super();
		this.mcno = mcno;
		this.mcname = mcname;
		this.mcage = mcage;
		this.mctime = mctime;
		this.mcstart = mcstart;
		this.mcend = mcend;
		this.mcact = mcact;
		this.mcloc = mcloc;
		this.mclike = mclike;
		this.mcimg = mcimg;
		this.mcimgcas = mcimgcas;
		this.mcimginfo = mcimginfo;
		this.mcimgchk = mcimgchk;
		this.mcimgsale = mcimgsale;
	}

	@Override
	public String toString() {
		return "Musical [mcno=" + mcno + ", mcname=" + mcname + ", mcage=" + mcage + ", mctime=" + mctime + ", mcstart="
				+ mcstart + ", mcend=" + mcend + ", mcact=" + mcact + ", mcloc=" + mcloc + ", mclike=" + mclike
				+ ", mcimg=" + mcimg + ", mcimgcas=" + mcimgcas + ", mcimginfo=" + mcimginfo + ", mcimgchk=" + mcimgchk
				+ ", mcimgsale=" + mcimgsale + "]";
	}

	public int getMcno() {
		return mcno;
	}

	public void setMcno(int mcno) {
		this.mcno = mcno;
	}

	public String getMcname() {
		return mcname;
	}

	public void setMcname(String mcname) {
		this.mcname = mcname;
	}

	public String getMcage() {
		return mcage;
	}

	public void setMcage(String mcage) {
		this.mcage = mcage;
	}

	public String getMctime() {
		return mctime;
	}

	public void setMctime(String mctime) {
		this.mctime = mctime;
	}

	public String getMcstart() {
		return mcstart;
	}

	public void setMcstart(String mcstart) {
		this.mcstart = mcstart;
	}

	public String getMcend() {
		return mcend;
	}

	public void setMcend(String mcend) {
		this.mcend = mcend;
	}

	public String getMcact() {
		return mcact;
	}

	public void setMcact(String mcact) {
		this.mcact = mcact;
	}

	public String getMcloc() {
		return mcloc;
	}

	public void setMcloc(String mcloc) {
		this.mcloc = mcloc;
	}

	public int getMclike() {
		return mclike;
	}

	public void setMclike(int mclike) {
		this.mclike = mclike;
	}

	public String getMcimg() {
		return mcimg;
	}

	public void setMcimg(String mcimg) {
		this.mcimg = mcimg;
	}

	public String getMcimgcas() {
		return mcimgcas;
	}

	public void setMcimgcas(String mcimgcas) {
		this.mcimgcas = mcimgcas;
	}

	public String getMcimginfo() {
		return mcimginfo;
	}

	public void setMcimginfo(String mcimginfo) {
		this.mcimginfo = mcimginfo;
	}

	public String getMcimgchk() {
		return mcimgchk;
	}

	public void setMcimgchk(String mcimgchk) {
		this.mcimgchk = mcimgchk;
	}

	public String getMcimgsale() {
		return mcimgsale;
	}

	public void setMcimgsale(String mcimgsale) {
		this.mcimgsale = mcimgsale;
	}
	
	
	
}
