package pe.com.yanapan.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.yanapan.dao.UserDAO;
import pe.com.yanapan.dao.impl.UserDAOImpl;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.User;
import pe.com.yanapan.service.UserService;

@Service
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {

	@Override
	public User findByUserAndPassword(String user, String password)	throws BusinessException {
		
		UserDAO dao = new UserDAOImpl();
		
		return dao.findByUserAndPassword(user, password);
	}

}
