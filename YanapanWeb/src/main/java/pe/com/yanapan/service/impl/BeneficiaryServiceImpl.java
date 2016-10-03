package pe.com.yanapan.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.yanapan.dao.BeneficiaryDAO;
import pe.com.yanapan.dao.impl.BeneficiaryDAOImpl;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Beneficiary;
import pe.com.yanapan.service.BeneficiaryService;

@Service
@Transactional(rollbackFor=Exception.class)
public class BeneficiaryServiceImpl implements BeneficiaryService{

	@Override
	public Beneficiary findById(int idBeneficiary) throws BusinessException {
		
		BeneficiaryDAO dao = new BeneficiaryDAOImpl();
		
		return dao.findById(idBeneficiary);
	}

	@Override
	public List<Beneficiary> listAll() throws BusinessException {
		
		BeneficiaryDAO dao = new BeneficiaryDAOImpl();
		
		return dao.listAll();
	}

	@Override
	public Beneficiary insert(Beneficiary beneficiary) throws BusinessException {
		
		BeneficiaryDAO dao = new BeneficiaryDAOImpl();
		
		return dao.insert(beneficiary);
	}

	@Override
	public Beneficiary update(Beneficiary beneficiary) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
