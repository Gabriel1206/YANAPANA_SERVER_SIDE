package pe.com.yanapan.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.yanapan.dao.VisitDAO;
import pe.com.yanapan.dao.impl.VisitDAOImpl;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Visit;
import pe.com.yanapan.service.VisitService;

@Service
@Transactional(rollbackFor=Exception.class)
public class VisitServiceImpl implements VisitService{

	@Override
	public List<Visit> listAll() throws BusinessException {
		
		VisitDAO dao = new VisitDAOImpl();
		
		return dao.listAll();
	}

	@Override
	public Visit findById(int idVisit) throws BusinessException {
		
		VisitDAO dao = new VisitDAOImpl();
		
		return dao.findById(idVisit);
	}

	@Override
	public Visit insert(Visit visit) throws BusinessException {
		
		VisitDAO dao = new VisitDAOImpl();
		
		return dao.insert(visit);
	}

	
	
}
