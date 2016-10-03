package pe.com.yanapan.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.yanapan.dao.WorkingDateDAO;
import pe.com.yanapan.dao.impl.WorkingDateDAOImpl;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.WorkingDate;
import pe.com.yanapan.service.WorkingDateService;

@Service
@Transactional(rollbackFor=Exception.class)
public class WorkingDateServiceImpl implements WorkingDateService{

	@Override
	public List<WorkingDate> findById(int idWorkingDate)
			throws BusinessException {
		
		WorkingDateDAO dao = new WorkingDateDAOImpl();
		
		return dao.findById(idWorkingDate);
	}

	@Override
	public List<WorkingDate> findByUser(int idUser) throws BusinessException {
		
		WorkingDateDAO dao = new WorkingDateDAOImpl();
		
		return dao.findByUser(idUser);
	}

	@Override
	public WorkingDate insert(WorkingDate workingDate) throws BusinessException {
		
		WorkingDateDAO dao = new WorkingDateDAOImpl();
		
		return dao.insert(workingDate);
	}

	@Override
	public List<WorkingDate> listAll() throws BusinessException {
		
		WorkingDateDAO dao = new WorkingDateDAOImpl();
		
		return dao.listAll();
	}

}
