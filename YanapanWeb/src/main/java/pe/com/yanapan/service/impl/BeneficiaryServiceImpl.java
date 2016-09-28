package pe.com.yanapan.service.impl;

import java.util.List;

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

}
