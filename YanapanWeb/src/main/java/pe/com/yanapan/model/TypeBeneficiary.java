package pe.com.yanapan.model;

public class TypeBeneficiary {

	private int idTypeBeneficiary;
	private String descTypeBeneficiary;
	
	
	public int getIdTypeBeneficiary() {
		return idTypeBeneficiary;
	}
	public void setIdTypeBeneficiary(int idTypeBeneficiary) {
		this.idTypeBeneficiary = idTypeBeneficiary;
	}
	public String getDescTypeBeneficiary() {
		return descTypeBeneficiary;
	}
	public void setDescTypeBeneficiary(String descTypeBeneficiary) {
		this.descTypeBeneficiary = descTypeBeneficiary;
	}
	
	@Override
	public String toString() {
		return "TypeBeneficiary [idTypeBeneficiary=" + idTypeBeneficiary
				+ ", descTypeBeneficiary=" + descTypeBeneficiary + "]";
	}
	
	
	
}
