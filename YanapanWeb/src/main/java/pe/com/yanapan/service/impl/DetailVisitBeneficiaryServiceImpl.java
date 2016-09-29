package pe.com.yanapan.service.impl;

import java.util.List;

import pe.com.yanapan.dao.DetailVisitBeneficiaryDAO;
import pe.com.yanapan.dao.impl.DetailVisitBeneficiaryDAOImpl;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.DetailVisitBeneficiary;
import pe.com.yanapan.service.DetailVisitBeneficiaryService;

public class DetailVisitBeneficiaryServiceImpl implements DetailVisitBeneficiaryService{

	@Override
	public List<DetailVisitBeneficiary> listByIdVisit(int idVisit)
			throws BusinessException {
		
		DetailVisitBeneficiaryDAO dao = new DetailVisitBeneficiaryDAOImpl();
		
		return dao.listByIdVisit(idVisit);
	}

	@Override
	public DetailVisitBeneficiary insert(
			DetailVisitBeneficiary detailVisitBeneficiary)
			throws BusinessException {
		
		DetailVisitBeneficiaryDAO dao = new DetailVisitBeneficiaryDAOImpl();
		
		return dao.insert(detailVisitBeneficiary);
	}

	
	
}
