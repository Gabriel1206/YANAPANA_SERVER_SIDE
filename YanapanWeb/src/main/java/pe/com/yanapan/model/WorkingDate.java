package pe.com.yanapan.model;

import java.util.Date;

public class WorkingDate {

	private int idWorkingDate;
	private Date time;
	private String type;
	private User user;
	
	
	public int getIdWorkingDate() {
		return idWorkingDate;
	}
	public void setIdWorkingDate(int idWorkingDate) {
		this.idWorkingDate = idWorkingDate;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "WorkingDate [idWorkingDate=" + idWorkingDate + ", time=" + time
				+ ", type=" + type + ", user=" + user + "]";
	}
	
	
	
	
	
	
}
