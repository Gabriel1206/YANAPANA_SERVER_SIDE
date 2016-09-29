package pe.com.yanapan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.com.yanapan.dao.UbigeoDAO;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Ubigeo;
import pe.com.yanapan.utils.ClsConexion;

public class UbigeoDAOImpl implements UbigeoDAO{

	private  ClsConexion conexion= new ClsConexion();
	
	public Ubigeo findById(int idUbigeo) throws BusinessException {
		
		String sql = "select idUbigeo, descUbigeo from ubigeo "
				+ "where idUbigeo = ?";
		
		Connection conn = null;
		Ubigeo ubigeoBean = null;
		
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idUbigeo);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				ubigeoBean = new Ubigeo();
				ubigeoBean.setIdUbigeo(rs.getInt(1));
				ubigeoBean.setDescUbigeo(rs.getString(2));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ubigeoBean;
	}

	@Override
	public List<Ubigeo> listAll() throws BusinessException {
		
		String sql = "select idUbigeo, descUbigeo from ubigeo";
		
		Connection conn = null;
		Ubigeo ubigeoBean = null;
		List<Ubigeo> lstUbigeos = new ArrayList<Ubigeo>();
		
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				ubigeoBean = new Ubigeo();
				ubigeoBean.setIdUbigeo(rs.getInt(1));
				ubigeoBean.setDescUbigeo(rs.getString(2));
				lstUbigeos.add(ubigeoBean);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lstUbigeos;
	}

}
