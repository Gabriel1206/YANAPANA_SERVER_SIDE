package pe.com.yanapan.model;

public class DetailVisitBeneficiary {

	private int idVisit;
	private String note;
	private String urlPhoto1;
	private String urlPhoto2;
	private Beneficiary beneficiary;
	
	public int getIdVisit() {
		return idVisit;
	}
	public void setIdVisit(int idVisit) {
		this.idVisit = idVisit;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getUrlPhoto1() {
		return urlPhoto1;
	}
	public void setUrlPhoto1(String urlPhoto1) {
		this.urlPhoto1 = urlPhoto1;
	}
	public String getUrlPhoto2() {
		return urlPhoto2;
	}
	public void setUrlPhoto2(String urlPhoto2) {
		this.urlPhoto2 = urlPhoto2;
	}
	public Beneficiary getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}
	
	@Override
	public String toString() {
		return "DetailVisitBeneficiary [idVisit=" + idVisit + ", note=" + note
				+ ", urlPhoto1=" + urlPhoto1 + ", urlPhoto2=" + urlPhoto2
				+ ", beneficiary=" + beneficiary + "]";
	}
	
	
}
