package pe.com.yanapan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.yanapan.beans.Retorno;
import pe.com.yanapan.dao.UsersDAO;
import pe.com.yanapan.model.User;
import pe.com.yanapan.utils.ClsConexion;

@Repository
public class UsersDAOImpl implements UsersDAO {

	private  Connection conn=null;
	private  ClsConexion conexion= new ClsConexion();
	
	@Override
	public List<User> listAllUser() {
		String sql = "select u.idUser, u.nickUser, u.password, u.firstName, u.lastName, u.birthDate "
				+ "from user u ";
		List<User> lstUser = new ArrayList<>();
		Connection conn = null;
		User userBean = null;
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				userBean = new User();
				userBean.setIdUser(rs.getInt(1));
				userBean.setNickUser(rs.getString(2));
				userBean.setPassword(rs.getString(3));
				userBean.setFirstName(rs.getString(4));
				userBean.setLastName(rs.getString(5));
				userBean.setBirthdate(rs.getDate(6));
				lstUser.add(userBean);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lstUser;
	}

	@Override
	public Retorno saveUser(User user) {
		
		Retorno retorno = new Retorno();
		
		String sql = "update user set nickUser = " + user.getNickUser() + ", password = " + user.getPassword() + " "
				+ "Where idUser = ? ";
		
		try {
			
		}catch (Exception e){
			
		}
		return retorno;
	}
	
}
