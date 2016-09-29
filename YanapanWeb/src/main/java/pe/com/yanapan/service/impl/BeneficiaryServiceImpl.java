package pe.com.yanapan.service.impl;

import java.util.List;

<<<<<<< HEAD
import pe.com.yanapan.dao.BeneficiaryDAO;
import pe.com.yanapan.dao.impl.BeneficiaryDAOImpl;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Beneficiary;
import pe.com.yanapan.service.BeneficiaryService;

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
		
		BeneficiaryDAO dao = new BeneficiaryDAOImpl();
		
		return dao.update(beneficiary);
	}
=======
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pe.com.yanapan.model.Beneficiary;
import pe.com.yanapan.service.BeneficiaryService;
import pe.com.yanapan.beans.ReportBeneficiary;
import pe.com.yanapan.dao.BeneficiaryDAO;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Resource
	private BeneficiaryDAO beneficiaryDAO;
	
	@Override
	public List<Beneficiary> listAllBeneficiary() {
		return beneficiaryDAO.listAllBeneficiary();
	}

	/*@Override
	public ReportBeneficiary reportBeneficiary(int pagina, int registros, int idBeneficiary) {
		return beneficiaryDAO.reportBeneficiary(pagina, registros, idBeneficiary);
	}*/
>>>>>>> d94ce494ab9f8c5610d34c6dd957abaa74de1c6c

}
