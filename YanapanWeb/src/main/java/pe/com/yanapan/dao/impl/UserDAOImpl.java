package pe.com.yanapan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pe.com.yanapan.dao.UserDAO;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Profile;
import pe.com.yanapan.model.User;
import pe.com.yanapan.utils.ClsConexion;

public class UserDAOImpl implements UserDAO {

	private  Connection conn=null;
	private  ClsConexion conexion= new ClsConexion();
	
	@Override
	public User findByUserAndPassword(String user, String password) throws BusinessException {
		
		String sql = "select u.idUser,u.nickUser,u.password,u.firstName,u.lastName,"
				+ "u.birthdate,p.idProfile,p.descProfile from user u, profile p "
				+ "where u.Profile_idProfile=p.idProfile and u.nickUser = ? and u.password = ?";
		
		Connection conn = null;
		User userBean = null;
		Profile profileBean = null;
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				userBean = new User();
				profileBean = new Profile();
				userBean.setIdUser(rs.getInt(1));
				userBean.setNickUser(rs.getString(2));
				userBean.setPassword(rs.getString(3));
				userBean.setFirstName(rs.getString(4));
				userBean.setLastName(rs.getString(5));
				userBean.setBirthdate(rs.getTimestamp(6));
				profileBean.setIdProfile(rs.getInt(7));
				profileBean.setDescProfile(rs.getString(8));
				userBean.setProfile(profileBean);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userBean;
	}

}
