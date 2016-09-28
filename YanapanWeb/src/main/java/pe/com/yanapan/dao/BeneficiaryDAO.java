package pe.com.yanapan.dao;

import java.util.List;

import pe.com.yanapan.model.Beneficiary;

public interface BeneficiaryDAO {

	public List<Beneficiary> listAllBeneficiary();
	
	//public ReportBeneficiary reportBeneficiary(int pagina, int registros, int idBeneficiary);
}
