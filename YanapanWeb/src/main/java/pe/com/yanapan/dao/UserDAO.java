package pe.com.yanapan.dao;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.User;

public interface UserDAO {
	
	User findByUserAndPassword(String user, String password) throws BusinessException;
	User insert(User user) throws BusinessException;

}
