package pe.com.yanapan.service;

import java.util.List;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Ubigeo;

public interface UbigeoService {

	Ubigeo findById(int idUbigeo) throws BusinessException;
	List<Ubigeo> listAll() throws BusinessException;
	
}
