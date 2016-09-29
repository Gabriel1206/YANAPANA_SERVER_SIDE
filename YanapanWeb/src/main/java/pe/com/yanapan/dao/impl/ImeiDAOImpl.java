package pe.com.yanapan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pe.com.yanapan.dao.ImeiDAO;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Imei;
import pe.com.yanapan.utils.ClsConexion;

public class ImeiDAOImpl implements ImeiDAO {

	private  ClsConexion conexion= new ClsConexion();
	
	@Override
	public Imei findByDescription(String descImei) throws BusinessException {
		
		String sql = "select idImei,descImei from imei where descImei = ?";
		
		Connection conn = null;
		Imei imeiBean = null;
		
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, descImei);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				
				imeiBean = new Imei();
				imeiBean.setIdImei(rs.getInt(1));
				imeiBean.setDescImei(rs.getString(2));
			}
			rs.close();
			ps.close();
			conn.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return imeiBean;
	}

}
