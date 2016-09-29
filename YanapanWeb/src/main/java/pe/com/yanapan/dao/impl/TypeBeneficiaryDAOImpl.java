package pe.com.yanapan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.com.yanapan.dao.TypeBeneficiaryDAO;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.TypeBeneficiary;
import pe.com.yanapan.utils.ClsConexion;

public class TypeBeneficiaryDAOImpl implements TypeBeneficiaryDAO {

	private  ClsConexion conexion= new ClsConexion();
	
	@Override
	public TypeBeneficiary findById(int idTypeBeneficiary) throws BusinessException {
		
		String sql = "select idTypeBeneficiary, descTypeBeneficiary from typebeneficiary "
				+ "where idTypeBeneficiary = ?";
		
		Connection conn = null;
		TypeBeneficiary typeBeneficiaryBean = null;
		
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idTypeBeneficiary);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				typeBeneficiaryBean = new TypeBeneficiary();
				typeBeneficiaryBean.setIdTypeBeneficiary(rs.getInt(1));
				typeBeneficiaryBean.setDescTypeBeneficiary(rs.getString(2));
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return typeBeneficiaryBean;
	}

	@Override
	public List<TypeBeneficiary> listAll() throws BusinessException {
		
		String sql = "select idTypeBeneficiary, descTypeBeneficiary from typebeneficiary";
		
		Connection conn = null;
		TypeBeneficiary typeBeneficiaryBean = null;
		List<TypeBeneficiary> lstTypeBeneficiaries = new ArrayList<TypeBeneficiary>();
		
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				typeBeneficiaryBean = new TypeBeneficiary();
				typeBeneficiaryBean.setIdTypeBeneficiary(rs.getInt(1));
				typeBeneficiaryBean.setDescTypeBeneficiary(rs.getString(2));
				lstTypeBeneficiaries.add(typeBeneficiaryBean);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lstTypeBeneficiaries;
	}

}
