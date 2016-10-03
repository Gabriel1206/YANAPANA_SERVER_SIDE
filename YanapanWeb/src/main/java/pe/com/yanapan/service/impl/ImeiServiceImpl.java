package pe.com.yanapan.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.yanapan.dao.ImeiDAO;
import pe.com.yanapan.dao.impl.ImeiDAOImpl;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Imei;
import pe.com.yanapan.service.ImeiService;

@Service
@Transactional(rollbackFor=Exception.class)
public class ImeiServiceImpl implements ImeiService{

	@Override
	public Imei findByDescription(String description) throws BusinessException {
		
		ImeiDAO dao = new ImeiDAOImpl();
		
		return dao.findByDescription(description);
	}

	@Override
	public Imei insert(Imei imei) throws BusinessException {
		
		ImeiDAO dao= new ImeiDAOImpl();
		
		return dao.insert(imei);
	}

}
