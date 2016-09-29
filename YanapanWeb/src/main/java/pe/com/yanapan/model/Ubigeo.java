package pe.com.yanapan.model;

public class Ubigeo {
	
	private int idUbigeo;
	private String descUbigeo;
	
	
	public int getIdUbigeo() {
		return idUbigeo;
	}
	public void setIdUbigeo(int idUbigeo) {
		this.idUbigeo = idUbigeo;
	}
	public String getDescUbigeo() {
		return descUbigeo;
	}
	public void setDescUbigeo(String descUbigeo) {
		this.descUbigeo = descUbigeo;
	}
	
	@Override
	public String toString() {
		return "Ubigeo [idUbigeo=" + idUbigeo + ", descUbigeo=" + descUbigeo
				+ "]";
	}
	
}
