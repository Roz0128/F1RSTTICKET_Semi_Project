package web.dto;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable{

	private int resno;
	private int scheduleInfoId;
	private String userid;
	private Date resdate;
	private int ticketcount;
	private String payment;
	private int paymoney;
	
	public Reservation() {	}

	public Reservation(int resno, int scheduleInfoId, String userid, Date resdate, int ticketcount, String payment,
			int paymoney) {
		super();
		this.resno = resno;
		this.scheduleInfoId = scheduleInfoId;
		this.userid = userid;
		this.resdate = resdate;
		this.ticketcount = ticketcount;
		this.payment = payment;
		this.paymoney = paymoney;
	}

	@Override
	public String toString() {
		return "Reservation [resno=" + resno + ", scheduleInfoId=" + scheduleInfoId + ", userid=" + userid
				+ ", resdate=" + resdate + ", ticketcount=" + ticketcount + ", payment=" + payment + ", paymoney="
				+ paymoney + "]";
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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getResdate() {
		return resdate;
	}

	public void setResdate(Date resdate) {
		this.resdate = resdate;
	}

	public int getTicketcount() {
		return ticketcount;
	}

	public void setTicketcount(int ticketcount) {
		this.ticketcount = ticketcount;
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