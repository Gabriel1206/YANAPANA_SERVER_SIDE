package pe.com.yanapan.service;

import java.util.List;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Beneficiary;
import pe.com.yanapan.model.User;

public interface BeneficiaryService {

	public List<Beneficiary> listAllBeneficiary();
	
}
