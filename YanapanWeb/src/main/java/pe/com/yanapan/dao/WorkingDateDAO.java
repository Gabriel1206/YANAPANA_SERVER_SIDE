package pe.com.yanapan.dao;

import java.util.List;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.WorkingDate;

public interface WorkingDateDAO {
	
	List<WorkingDate> findById(int idWorkingDate) throws BusinessException;
	List<WorkingDate> findByUser(int idUser) throws BusinessException;
	WorkingDate insert(WorkingDate workingDate) throws BusinessException;
	
}
