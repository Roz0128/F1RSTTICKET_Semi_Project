package web.dto;

import java.sql.Timestamp;
import java.util.Date;

public class MyReservation {

	private String userid;
	private String mcname;
	private Date scheduledate;
	private String scheduletime;
	private int ticketcount;
	private int paymoney;
	private int seatno;
	private Timestamp resdate;
	private String payment;
	private int mcno;
	private int scheduleInfoid;
	private int resno;
	
	public MyReservation() {}

	public MyReservation(String userid, String mcname, Date scheduledate, String scheduletime, int ticketcount,
			int paymoney, int seatno, Timestamp resdate, String payment, int mcno, int scheduleInfoid, int resno) {
		super();
		this.userid = userid;
		this.mcname = mcname;
		this.scheduledate = scheduledate;
		this.scheduletime = scheduletime;
		this.ticketcount = ticketcount;
		this.paymoney = paymoney;
		this.seatno = seatno;
		this.resdate = resdate;
		this.payment = payment;
		this.mcno = mcno;
		this.scheduleInfoid = scheduleInfoid;
		this.resno = resno;
	}

	@Override
	public String toString() {
		return "MyReservation [userid=" + userid + ", mcname=" + mcname + ", scheduledate=" + scheduledate
				+ ", scheduletime=" + scheduletime + ", ticketcount=" + ticketcount + ", paymoney=" + paymoney
				+ ", seatno=" + seatno + ", resdate=" + resdate + ", payment=" + payment + ", mcno=" + mcno
				+ ", scheduleInfoid=" + scheduleInfoid + ", resno=" + resno + "]";
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getMcname() {
		return mcname;
	}

	public void setMcname(String mcname) {
		this.mcname = mcname;
	}

	public Date getScheduledate() {
		return scheduledate;
	}

	public void setScheduledate(Date scheduledate) {
		this.scheduledate = scheduledate;
	}

	public String getScheduletime() {
		return scheduletime;
	}

	public void setScheduletime(String scheduletime) {
		this.scheduletime = scheduletime;
	}

	public int getTicketcount() {
		return ticketcount;
	}

	public void setTicketcount(int ticketcount) {
		this.ticketcount = ticketcount;
	}

	public int getPaymoney() {
		return paymoney;
	}

	public void setPaymoney(int paymoney) {
		this.paymoney = paymoney;
	}

	public int getSeatno() {
		return seatno;
	}

	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}

	public Timestamp getResdate() {
		return resdate;
	}

	public void setResdate(Timestamp resdate) {
		this.resdate = resdate;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getMcno() {
		return mcno;
	}

	public void setMcno(int mcno) {
		this.mcno = mcno;
	}

	public int getScheduleInfoid() {
		return scheduleInfoid;
	}

	public void setScheduleInfoid(int scheduleInfoid) {
		this.scheduleInfoid = scheduleInfoid;
	}

	public int getResno() {
		return resno;
	}

	public void setResno(int resno) {
		this.resno = resno;
	}
	
	
	
}
