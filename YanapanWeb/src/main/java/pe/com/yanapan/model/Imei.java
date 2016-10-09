package pe.com.yanapan.model;

public class Imei {

	private int idImei;
	private String descImei;
	

	public Imei() {
		super();
	}
	
	public int getIdImei() {
		return idImei;
	}
	public void setIdImei(int idImei) {
		this.idImei = idImei;
	}
	public String getDescImei() {
		return descImei;
	}
	public void setDescImei(String descImei) {
		this.descImei = descImei;
	}
	
	
	@Override
	public String toString() {
		return "Imei [idImei=" + idImei + 
				", descImei=" + descImei + "]";
	}
	
	
	
}
