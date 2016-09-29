package pe.com.yanapan.service.impl;

import java.util.List;

import pe.com.yanapan.dao.TypeBeneficiaryDAO;
import pe.com.yanapan.dao.impl.TypeBeneficiaryDAOImpl;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.TypeBeneficiary;
import pe.com.yanapan.service.TypeBeneficiaryService;

public class TypeBeneficiaryServiceImpl implements TypeBeneficiaryService{

	@Override
	public TypeBeneficiary findById(int idTypeBeneficiary)
			throws BusinessException {
		
		TypeBeneficiaryDAO dao = new TypeBeneficiaryDAOImpl();
		
		return dao.findById(idTypeBeneficiary);
	}

	@Override
	public List<TypeBeneficiary> listAll() throws BusinessException {
		
		TypeBeneficiaryDAO dao = new TypeBeneficiaryDAOImpl();
		
		return dao.listAll();
	}

	
	
}
