package pe.com.yanapan.model;

import java.util.Date;

public class WorkingDate {

	private int idWorkingDate;
	private String time;
	private String type;
	private String longitude;
	private String latitude;
	private User user;
	
		
	
	
	public WorkingDate() {
	}



	public int getIdWorkingDate() {
		return idWorkingDate;
	}
	public void setIdWorkingDate(int idWorkingDate) {
		this.idWorkingDate = idWorkingDate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
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

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	@Override
	public String toString() {
		return "WorkingDate [idWorkingDate=" + idWorkingDate + ", time=" + time
				+ ", type=" + type + ", longitude=" + longitude + ", latitude="
				+ latitude + ", user=" + user + "]";
	}
	
			
	
}
