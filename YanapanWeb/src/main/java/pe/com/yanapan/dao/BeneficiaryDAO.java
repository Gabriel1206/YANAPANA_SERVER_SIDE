package pe.com.yanapan.dao;

import java.util.List;

<<<<<<< HEAD
import pe.com.yanapan.exceptions.BusinessException;
=======
>>>>>>> d94ce494ab9f8c5610d34c6dd957abaa74de1c6c
import pe.com.yanapan.model.Beneficiary;

public interface BeneficiaryDAO {

<<<<<<< HEAD
	Beneficiary findById(int idBeneficiary) throws BusinessException;
	List<Beneficiary> listAll() throws BusinessException;
	Beneficiary insert(Beneficiary beneficiary) throws BusinessException;
	Beneficiary update(Beneficiary beneficiary) throws BusinessException;
=======
	public List<Beneficiary> listAllBeneficiary();
	
	//public ReportBeneficiary reportBeneficiary(int pagina, int registros, int idBeneficiary);
>>>>>>> d94ce494ab9f8c5610d34c6dd957abaa74de1c6c
}
