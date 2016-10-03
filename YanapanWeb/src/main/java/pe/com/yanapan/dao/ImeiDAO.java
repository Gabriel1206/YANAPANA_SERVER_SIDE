package pe.com.yanapan.dao;

import java.util.List;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Imei;

public interface ImeiDAO {

	Imei findByDescription(String descImei) throws BusinessException;
	List<Imei> listAll() throws BusinessException;
	Imei insert(Imei imei) throws BusinessException;
}
