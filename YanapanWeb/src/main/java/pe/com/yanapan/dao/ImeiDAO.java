package pe.com.yanapan.dao;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Imei;

public interface ImeiDAO {

	Imei findByDescription(String descImei) throws BusinessException;
	
}
