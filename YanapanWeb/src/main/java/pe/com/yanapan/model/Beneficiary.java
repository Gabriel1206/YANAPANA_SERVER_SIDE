package pe.com.yanapan.model;

import java.util.Date;

public class Beneficiary {
	private int idBeneficiary;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String address;
	private char flagDisabled;
	private char flagKnowledge;
	private String descKnowledge;
	private int idUbigeo;
	private int typeBeneficiary;
	public int getIdBeneficiary() {
		return idBeneficiary;
	}
	public void setIdBeneficiary(int idBeneficiary) {
		this.idBeneficiary = idBeneficiary;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public char getFlagDisabled() {
		return flagDisabled;
	}
	public void setFlagDisabled(char flagDisabled) {
		this.flagDisabled = flagDisabled;
	}
	public char getFlagKnowledge() {
		return flagKnowledge;
	}
	public void setFlagKnowledge(char flagKnowledge) {
		this.flagKnowledge = flagKnowledge;
	}
	public String getDescKnowledge() {
		return descKnowledge;
	}
	public void setDescKnowledge(String descKnowledge) {
		this.descKnowledge = descKnowledge;
	}
	public int getIdUbigeo() {
		return idUbigeo;
	}
	public void setIdUbigeo(int idUbigeo) {
		this.idUbigeo = idUbigeo;
	}
	public int getTypeBeneficiary() {
		return typeBeneficiary;
	}
	public void setTypeBeneficiary(int typeBeneficiary) {
		this.typeBeneficiary = typeBeneficiary;
	}
	
	@Override
	public String toString() {
		return "Benficiary [idBeneficiary=" + idBeneficiary + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", address=" + address + ", flagDisabled=" + flagDisabled
				+ ", flagKnowledge=" + flagKnowledge + ", descKnowledge=" + descKnowledge 
				+ ", idUbigeo=" + idUbigeo + ", typeBeneficiary=" + typeBeneficiary + "]";
	}
}
 