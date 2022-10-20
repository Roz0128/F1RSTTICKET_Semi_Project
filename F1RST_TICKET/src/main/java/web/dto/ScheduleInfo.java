package web.dto;

import java.util.Date;

public class ScheduleInfo {
	
	private int scheduleInfoId;
	private int mcno;
	private Date scheduledate;
	private String scheduletime;
	
	public ScheduleInfo() {	}

	public ScheduleInfo(int scheduleinfoid, int mcno, Date scheduledate, String scheduletime) {
		super();
		this.scheduleInfoId = scheduleinfoid;
		this.mcno = mcno;
		this.scheduledate = scheduledate;
		this.scheduletime = scheduletime;
	}

	@Override
	public String toString() {
		return "ScheduleInfo [scheduleinfoid=" + scheduleInfoId + ", mcno=" + mcno + ", scheduledate=" + scheduledate
				+ ", scheduletime=" + scheduletime + "]";
	}

	public int getScheduleInfoId() {
		return scheduleInfoId;
	}

	public void setScheduleInfoId(int scheduleinfoid) {
		this.scheduleInfoId = scheduleinfoid;
	}

	public int getMcno() {
		return mcno;
	}

	public void setMcno(int mcno) {
		this.mcno = mcno;
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

	
}
