package pe.com.yanapan.service;

import java.util.List;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.WorkingDate;

public interface WorkingDateService {

	List<WorkingDate> findById(int idWorkingDate) throws BusinessException;
	List<WorkingDate> findByUser(int idUser) throws BusinessException;
	List<WorkingDate> listAll() throws BusinessException;
	WorkingDate insert(WorkingDate workingDate) throws BusinessException;
	
}
