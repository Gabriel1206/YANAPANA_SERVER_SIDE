package pe.com.yanapan.service.impl;

import java.util.List;

import pe.com.yanapan.dao.UbigeoDAO;
import pe.com.yanapan.dao.impl.UbigeoDAOImpl;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Ubigeo;
import pe.com.yanapan.service.UbigeoService;

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
