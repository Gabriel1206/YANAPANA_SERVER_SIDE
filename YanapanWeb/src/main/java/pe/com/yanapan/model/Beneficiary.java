package pe.com.yanapan.model;

import java.util.Date;

public class Beneficiary {


	private int idBeneficiary;
	private String documentBeneficiary;
	private String firstName;
	private String lastName;
	private String birthdate;
	private String address;
	private String flagDisabled;
	private String flagKnowledge;
	private String descKnowledge;
	private TypeBeneficiary typeBeneficiary;
	private Ubigeo ubigeo;
	
	
	public int getIdBeneficiary() {
		return idBeneficiary;
	}
	public void setIdBeneficiary(int idBeneficiary) {
		this.idBeneficiary = idBeneficiary;
	}
	public String getDocumentBeneficiary() {
		return documentBeneficiary;
	}
	public void setDocumentBeneficiary(String documentBeneficiary) {
		this.documentBeneficiary = documentBeneficiary;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFlagDisabled() {
		return flagDisabled;
	}
	public void setFlagDisabled(String flagDisabled) {
		this.flagDisabled = flagDisabled;
	}
	public String getFlagKnowledge() {
		return flagKnowledge;
	}
	public void setFlagKnowledge(String flagKnowledge) {
		this.flagKnowledge = flagKnowledge;
	}
	public String getDescKnowledge() {
		return descKnowledge;
	}
	public void setDescKnowledge(String descKnowledge) {
		this.descKnowledge = descKnowledge;
	}
	public TypeBeneficiary getTypeBeneficiary() {
		return typeBeneficiary;
	}
	public void setTypeBeneficiary(TypeBeneficiary typeBeneficiary) {
		this.typeBeneficiary = typeBeneficiary;
	}
	public Ubigeo getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	@Override
	public String toString() {
		return "Beneficiary [idBeneficiary=" + idBeneficiary
				+ ", documentBeneficiary=" + documentBeneficiary
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthdate=" + birthdate + ", address=" + address
				+ ", flagDisabled=" + flagDisabled + ", flagKnowledge="
				+ flagKnowledge + ", descKnowledge=" + descKnowledge
				+ ", typeBeneficiary=" + typeBeneficiary + ", ubigeo=" + ubigeo
				+ "]";
	}
	
	
	
}
