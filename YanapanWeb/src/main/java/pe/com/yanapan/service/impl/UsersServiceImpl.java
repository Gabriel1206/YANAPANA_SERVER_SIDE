package pe.com.yanapan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pe.com.yanapan.dao.UsersDAO;
import pe.com.yanapan.model.User;
import pe.com.yanapan.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Resource
	private UsersDAO usersDAO;
	
	@Override
	public List<User> listAllUser() {
		return usersDAO.listAllUser();
	}

}
