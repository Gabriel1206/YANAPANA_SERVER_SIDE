package pe.com.yanapan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

		if (user.getIdUser() != 0) {
				
			String sql = "update user set nickUser = ?, password = ?, firstName = ?, lastName = ? "
					+ "Where idUser = " + user.getIdUser();
			try {
				conn = conexion.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user.getNickUser());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getFirstName());
				ps.setString(4, user.getLastName());				
				ps.executeUpdate();
				conn.close();
				String codigoUser = String.valueOf(user.getIdUser());
				String mensaje = (String) "Registro, actualizado correctamente...";
				retorno.setCodigoRetorno(codigoUser);
				retorno.setMensajeRetorno(mensaje);
			}catch (Exception e){
				e.printStackTrace();
			}
		} else {
			// create a sql date object so we can use it in our INSERT statement
		      /*Calendar calendar = Calendar.getInstance();
		      java.sql.Date birthdate = new java.sql.Date(calendar.getTime().getTime());*/
			
			String sql = "insert into user (idUser, nickUser, password, firstName, lastName, birthdate, Profile_idProfile) "
					+ "values (?, ?, ?, ?, ?, ?, ?) ";
			try {
				conn = conexion.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, user.getIdUser());
				ps.setString(2, user.getNickUser());
				ps.setString(3, user.getPassword());
				ps.setString(4, user.getFirstName());
				ps.setString(5, user.getLastName());
				Date birthdate = new Date();
				birthdate = user.getBirthdate();
				ps.setDate(6, (java.sql.Date) birthdate);
				ps.executeUpdate();
				conn.close();
				String codigoUser = String.valueOf(user.getIdUser());
				String mensaje = (String) "Registro, insertado correctamente...";
				retorno.setCodigoRetorno(codigoUser);
				retorno.setMensajeRetorno(mensaje);
			}catch (Exception e){
				e.printStackTrace();
			}			
		}
		return retorno;		
	}

	
}
