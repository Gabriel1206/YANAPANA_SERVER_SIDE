package pe.com.yanapan.service;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Imei;

public interface ImeiService {

	Imei findByDescription (String description) throws BusinessException;
}
