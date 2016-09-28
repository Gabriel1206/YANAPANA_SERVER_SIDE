package pe.com.yanapan.dao;

import java.util.List;

import pe.com.yanapan.beans.Retorno;
import pe.com.yanapan.model.User;

public interface UsersDAO {

	public List<User> listAllUser();
	
	public Retorno saveUser(User user);
}
