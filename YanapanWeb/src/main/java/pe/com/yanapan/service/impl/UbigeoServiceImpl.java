package pe.com.yanapan.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.yanapan.dao.UbigeoDAO;
import pe.com.yanapan.dao.impl.UbigeoDAOImpl;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Ubigeo;
import pe.com.yanapan.service.UbigeoService;

@Service
@Transactional(rollbackFor=Exception.class)
public class UbigeoServiceImpl implements UbigeoService{

	@Override
	public Ubigeo findById(int idUbigeo) throws BusinessException {
		
		UbigeoDAO dao = new UbigeoDAOImpl();
		
		return dao.findById(idUbigeo);
	}

	@Override
	public List<Ubigeo> listAll() throws BusinessException {
		
		UbigeoDAO dao = new UbigeoDAOImpl();
		
		return dao.listAll();
	}

}
