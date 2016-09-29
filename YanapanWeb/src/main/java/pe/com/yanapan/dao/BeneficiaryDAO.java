package pe.com.yanapan.dao;

import java.util.List;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Beneficiary;

public interface BeneficiaryDAO {

	Beneficiary findById(int idBeneficiary) throws BusinessException;
	List<Beneficiary> listAll() throws BusinessException;
	Beneficiary insert(Beneficiary beneficiary) throws BusinessException;
	Beneficiary update(Beneficiary beneficiary) throws BusinessException;
}
