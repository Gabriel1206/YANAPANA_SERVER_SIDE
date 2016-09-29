package pe.com.yanapan.beans;

import java.util.List;

import pe.com.yanapan.model.Beneficiary;

public class ReportBeneficiary {
	List<Beneficiary> listBeneficiary;
	int totalregistros;
	
	public List<Beneficiary> getListBeneficiary() {
		return listBeneficiary;
	}
	public void setListBeneficiary(List<Beneficiary> listBeneficiary) {
		this.listBeneficiary = listBeneficiary;
	}
	public int getTotalregistros() {
		return totalregistros;
	}
	public void setTotalregistros(int totalregistros) {
		this.totalregistros = totalregistros;
	}

}
