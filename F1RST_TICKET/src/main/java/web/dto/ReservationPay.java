package web.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class ReservationPay implements Serializable{

	private int mrno;
	private int resno;
	private int scheduleInfoId;
	private int mcno;
	private String mcname;
	private String scheduledate;
	private String scheduletime;
	private String userid;
	private Timestamp resdate;
	private int ticketcount;
	private int payno;
	private String payment;
	private int paymoney;

	
	public ReservationPay() {}


	public ReservationPay(int mrno, int resno, int scheduleInfoId, int mcno, String mcname, String scheduledate,
			String scheduletime, String userid, Timestamp resdate, int ticketcount, int payno, String payment,
			int paymoney) {
		super();
		this.mrno = mrno;
		this.resno = resno;
		this.scheduleInfoId = scheduleInfoId;
		this.mcno = mcno;
		this.mcname = mcname;
		this.scheduledate = scheduledate;
		this.scheduletime = scheduletime;
		this.userid = userid;
		this.resdate = resdate;
		this.ticketcount = ticketcount;
		this.payno = payno;
		this.payment = payment;
		this.paymoney = paymoney;
	}


	@Override
	public String toString() {
		return "ReservationPay [mrno=" + mrno + ", resno=" + resno + ", scheduleInfoId=" + scheduleInfoId + ", mcno="
				+ mcno + ", mcname=" + mcname + ", scheduledate=" + scheduledate + ", scheduletime=" + scheduletime
				+ ", userid=" + userid + ", resdate=" + resdate + ", ticketcount=" + ticketcount + ", payno=" + payno
				+ ", payment=" + payment + ", paymoney=" + paymoney + "]";
	}


	public int getMrno() {
		return mrno;
	}


	public void setMrno(int mrno) {
		this.mrno = mrno;
	}


	public int getResno() {
		return resno;
	}


	public void setResno(int resno) {
		this.resno = resno;
	}


	public int getScheduleInfoId() {
		return scheduleInfoId;
	}


	public void setScheduleInfoId(int scheduleInfoId) {
		this.scheduleInfoId = scheduleInfoId;
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


	public String getScheduledate() {
		return scheduledate;
	}


	public void setScheduledate(String scheduledate) {
		this.scheduledate = scheduledate;
	}


	public String getScheduletime() {
		return scheduletime;
	}


	public void setScheduletime(String scheduletime) {
		this.scheduletime = scheduletime;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public Timestamp getResdate() {
		return resdate;
	}


	public void setResdate(Timestamp resdate) {
		this.resdate = resdate;
	}


	public int getTicketcount() {
		return ticketcount;
	}


	public void setTicketcount(int ticketcount) {
		this.ticketcount = ticketcount;
	}


	public int getPayno() {
		return payno;
	}


	public void setPayno(int payno) {
		this.payno = payno;
	}


	public String getPayment() {
		return payment;
	}


	public void setPayment(String payment) {
		this.payment = payment;
	}


	public int getPaymoney() {
		return paymoney;
	}


	public void setPaymoney(int paymoney) {
		this.paymoney = paymoney;
	}


	
	
}