package pe.com.yanapan.dao;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.User;

public interface UserDAO {
	
	User findByUserAndPassword(String user, String password) throws BusinessException;
<<<<<<< HEAD
	User insert(User user) throws BusinessException;
=======
	
>>>>>>> d94ce494ab9f8c5610d34c6dd957abaa74de1c6c
}
