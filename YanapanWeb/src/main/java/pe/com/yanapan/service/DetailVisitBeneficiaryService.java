package pe.com.yanapan.service;

import java.util.List;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.DetailVisitBeneficiary;

public interface DetailVisitBeneficiaryService {

	List<DetailVisitBeneficiary> listByIdVisit(int idVisit) throws BusinessException;
	DetailVisitBeneficiary insert(DetailVisitBeneficiary detailVisitBeneficiary) throws BusinessException;
	
}
