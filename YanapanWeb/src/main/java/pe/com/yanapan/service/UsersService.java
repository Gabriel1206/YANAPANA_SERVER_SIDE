package pe.com.yanapan.service;

import java.util.List;

import pe.com.yanapan.beans.Retorno;
import pe.com.yanapan.model.User;

public interface UsersService {

	public List<User> listAllUser();
	
	public Retorno saveUser(User user);
}
