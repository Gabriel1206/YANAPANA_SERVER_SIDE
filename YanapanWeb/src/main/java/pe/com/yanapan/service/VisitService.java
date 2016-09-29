package pe.com.yanapan.service;

import java.util.List;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Visit;

public interface VisitService {

	List<Visit> listAll() throws BusinessException;
	Visit findById(int idVisit) throws BusinessException;
	Visit insert(Visit visit) throws BusinessException;
	
}
