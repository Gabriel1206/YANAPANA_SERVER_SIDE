package pe.com.yanapan.model;

import java.util.List;

public class Visit {

	private int idVisit;
	private String longitude;
	private String latitude;
	private List<DetailVisitBeneficiary> lstDetailVisitBeneficiary;
	private User user;
		
	public Visit() {
		super();
	}
	public int getIdVisit() {
		return idVisit;
	}
	public void setIdVisit(int idVisit) {
		this.idVisit = idVisit;
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
			
	public List<DetailVisitBeneficiary> getLstDetailVisitBeneficiary() {
		return lstDetailVisitBeneficiary;
	}
	public void setLstDetailVisitBeneficiary(
			List<DetailVisitBeneficiary> lstDetailVisitBeneficiary) {
		this.lstDetailVisitBeneficiary = lstDetailVisitBeneficiary;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Visit [idVisit=" + idVisit + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", lstDetailVisitBeneficiary="
				+ lstDetailVisitBeneficiary + ", user=" + user + "]";
	}
	
	
	
		
}
