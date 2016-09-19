package pe.com.yanapan.model;

public class Profile {

	private int idProfile;
	private String descProfile;
	
	
	public int getIdProfile() {
		return idProfile;
	}
	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
	}
	public String getDescProfile() {
		return descProfile;
	}
	public void setDescProfile(String descProfile) {
		this.descProfile = descProfile;
	}
	
	@Override
	public String toString() {
		return "Profile [idProfile=" + idProfile + ", descProfile="
				+ descProfile + "]";
	}
	
}
