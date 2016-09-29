package pe.com.yanapan.model;

import java.util.Date;

public class WorkingDate {

	private int idWorkingDate;
	private Date startDay;
	private Date endDay;
	private int idUser;
	
	
	public int getIdWorkingDate() {
		return idWorkingDate;
	}
	public void setIdWorkingDate(int idWorkingDate) {
		this.idWorkingDate = idWorkingDate;
	}
	public Date getStartDay() {
		return startDay;
	}
	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}
	public Date getEndDay() {
		return endDay;
	}
	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	@Override
	public String toString() {
		return "WorkingDate [idWorkingDate=" + idWorkingDate + ", startDay="
				+ startDay + ", endDay=" + endDay + ", idUser=" + idUser + "]";
	}
	
	
	
}
