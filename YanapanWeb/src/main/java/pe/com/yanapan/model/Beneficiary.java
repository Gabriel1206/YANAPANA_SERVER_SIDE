package pe.com.yanapan.model;

import java.util.Date;

public class Beneficiary {
<<<<<<< HEAD

	private int idBeneficiary;
	private String documentBeneficiary;
	private String firstName;
	private String lastName;
	private Date birthdate;
	private String address;
	private String flagDisabled;
	private String flagKnowledge;
	private String descKnowledge;
	private TypeBeneficiary typeBeneficiary;
	private Ubigeo ubigeo;
	
	
	
	public String getDocumentBeneficiary() {
		return documentBeneficiary;
	}
	public void setDocumentBeneficiary(String documentBeneficiary) {
		this.documentBeneficiary = documentBeneficiary;
	}
=======
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
>>>>>>> d94ce494ab9f8c5610d34c6dd957abaa74de1c6c
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
<<<<<<< HEAD
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
=======
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
>>>>>>> d94ce494ab9f8c5610d34c6dd957abaa74de1c6c
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
<<<<<<< HEAD
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
=======
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
>>>>>>> d94ce494ab9f8c5610d34c6dd957abaa74de1c6c
		this.flagKnowledge = flagKnowledge;
	}
	public String getDescKnowledge() {
		return descKnowledge;
	}
	public void setDescKnowledge(String descKnowledge) {
		this.descKnowledge = descKnowledge;
	}
<<<<<<< HEAD
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
=======
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
 
>>>>>>> d94ce494ab9f8c5610d34c6dd957abaa74de1c6c
