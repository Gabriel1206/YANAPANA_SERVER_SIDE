package pe.com.yanapan.dao;

import java.util.List;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.TypeBeneficiary;

public interface TypeBeneficiaryDAO {

	TypeBeneficiary findById(int idTypeBeneficiary) throws BusinessException;
	List<TypeBeneficiary> listAll() throws BusinessException;
	
}
