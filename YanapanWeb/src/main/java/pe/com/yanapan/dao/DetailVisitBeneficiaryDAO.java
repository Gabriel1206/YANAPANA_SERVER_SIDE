package pe.com.yanapan.dao;

import java.util.List;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.DetailVisitBeneficiary;

public interface DetailVisitBeneficiaryDAO {

	List<DetailVisitBeneficiary> listByIdVisit(int idVisit) throws BusinessException;
	DetailVisitBeneficiary insert(DetailVisitBeneficiary detailVisitBeneficiary) throws BusinessException;
}
