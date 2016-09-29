package pe.com.yanapan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.com.yanapan.dao.VisitDAO;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.DetailVisitBeneficiary;
import pe.com.yanapan.model.Visit;
import pe.com.yanapan.utils.ClsConexion;

public class VisitDAOImpl implements VisitDAO{

	private  ClsConexion conexion= new ClsConexion();
	
	@Override
	public List<Visit> listAll() throws BusinessException {
		
		String sql = "select idVisit,longitude, latitude from visit";
		
		Connection conn = null;
		Visit visitBean = null;
		List<DetailVisitBeneficiary> lstDetailVisitBeneficiary = null;
		List<Visit> lstVisit = new ArrayList<Visit>();
		
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				visitBean = new Visit();
				visitBean.setIdVisit(rs.getInt(1));
				visitBean.setLongitude(rs.getString(2));
				visitBean.setLatitude(rs.getString(3));
				lstDetailVisitBeneficiary = new DetailVisitBeneficiaryDAOImpl().listByIdVisit(rs.getInt(1));
				visitBean.setLstDetailBeneficiary(lstDetailVisitBeneficiary);
				lstVisit.add(visitBean);				
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lstVisit;
	}

	@Override
	public Visit findById(int idVisit) throws BusinessException {
		
		String sql = "select idVisit,longitude, latitude from visit where idVisit = ?";
		
		Connection conn = null;
		Visit visitBean = null;
		List<DetailVisitBeneficiary> lstDetailVisitBeneficiary = null;
		
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idVisit);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				visitBean = new Visit();
				visitBean.setIdVisit(rs.getInt(1));
				visitBean.setLongitude(rs.getString(2));
				visitBean.setLatitude(rs.getString(3));
				lstDetailVisitBeneficiary = new DetailVisitBeneficiaryDAOImpl().listByIdVisit(rs.getInt(1));
				visitBean.setLstDetailBeneficiary(lstDetailVisitBeneficiary);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return visitBean;
	}

	@Override
	public Visit insert(Visit visit) throws BusinessException {
		
		String sql = "insert into (longitude,latitude) visit "
				+ "values(?,?) ";
		
		Connection conn = null;
		
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, visit.getLongitude());
			ps.setString(2, visit.getLatitude());
			ps.executeUpdate();
			
			for (int i = 0; i < visit.getLstDetailBeneficiary().size(); i++) {
				new DetailVisitBeneficiaryDAOImpl().insert(visit.getLstDetailBeneficiary().get(i));
			}
			
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return visit;
	}

	
	
}
