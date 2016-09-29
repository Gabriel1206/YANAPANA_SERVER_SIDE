package pe.com.yanapan.dao;

import java.util.List;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Ubigeo;

public interface UbigeoDAO {
	
	Ubigeo findById(int idUbigeo) throws BusinessException;
	List<Ubigeo> listAll() throws BusinessException;
}
