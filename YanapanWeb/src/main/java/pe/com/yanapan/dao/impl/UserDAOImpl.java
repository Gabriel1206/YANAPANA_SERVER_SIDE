package pe.com.yanapan.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pe.com.yanapan.dao.UserDAO;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Profile;
import pe.com.yanapan.model.User;
import pe.com.yanapan.utils.ClsConexion;

public class UserDAOImpl implements UserDAO {

	private  ClsConexion conexion= new ClsConexion();
	
	@Override
	public User findByUserAndPassword(String user, String password) throws BusinessException {
		
		String sql = "select u.idUser,u.documentUser,u.nickUser,u.password,u.firstName,u.lastName,"
				+ "u.birthdate,p.idProfile,p.descProfile from user u, profile p "
				+ "where u.Profile_idProfile=p.idProfile and u.nickUser = ? and u.password = ?";
		
		Connection conn = null;
		User userBean = null;
		Profile profileBean = null;
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.toUpperCase());
			ps.setString(2, password.toUpperCase());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				userBean = new User();
				profileBean = new Profile();
				userBean.setIdUser(rs.getInt(1));
				userBean.setDocumentUser(rs.getString(2));
				userBean.setNickUser(rs.getString(3));
				userBean.setPassword(rs.getString(4));
				userBean.setFirstName(rs.getString(5));
				userBean.setLastName(rs.getString(6));
				userBean.setBirthdate(rs.getTimestamp(7));
				profileBean.setIdProfile(rs.getInt(8));
				profileBean.setDescProfile(rs.getString(9));
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

<<<<<<< HEAD
	@Override
	public User insert(User user) throws BusinessException {
		
		String sql = "insert into (documentUser,nickUser,password,firstName,lastName,birthDate,Profile_idProfile) user "
				+ "values(?,?,?,?,?,?,?) ";
		
		Connection conn = null;
		
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getDocumentUser());
			ps.setString(2, user.getNickUser());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setDate(6, (Date) user.getBirthdate());
			ps.setInt(7, user.getProfile().getIdProfile());
			
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
=======
>>>>>>> d94ce494ab9f8c5610d34c6dd957abaa74de1c6c

}
