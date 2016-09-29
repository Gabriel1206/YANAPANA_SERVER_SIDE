package pe.com.yanapan.service;

import java.util.List;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.TypeBeneficiary;

public interface TypeBeneficiaryService {

	TypeBeneficiary findById(int idTypeBeneficiary) throws BusinessException;
	List<TypeBeneficiary> listAll() throws BusinessException;
	
}
