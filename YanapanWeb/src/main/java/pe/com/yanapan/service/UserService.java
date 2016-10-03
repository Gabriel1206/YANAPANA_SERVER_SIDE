package pe.com.yanapan.service;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.User;

public interface UserService {

	User findByUserAndPassword(String user, String password) throws BusinessException;
	User insert(User user) throws BusinessException;
	User findById(int idUser) throws BusinessException;
}
