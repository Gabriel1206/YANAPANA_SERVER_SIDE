package pe.com.yanapan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.com.yanapan.dao.DetailVisitBeneficiaryDAO;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Beneficiary;
import pe.com.yanapan.model.DetailVisitBeneficiary;
import pe.com.yanapan.utils.ClsConexion;

public class DetailVisitBeneficiaryDAOImpl implements DetailVisitBeneficiaryDAO{

	private  ClsConexion conexion= new ClsConexion();
	
	@Override
	public List<DetailVisitBeneficiary> listByIdVisit(int idVisit)
			throws BusinessException {
		
		String sql = "select Visit_idVisit,Beneficiary_idBeneficiary, note, urlPhoto1,urlPhoto2 "
				+ "from detailvisitbeneficiary "
				+ "where Visit_idVisit = ?";
		
		Connection conn = null;
		DetailVisitBeneficiary detailVisitBeneficiaryBean = null;
		Beneficiary beneficiaryBean = null;
		List<DetailVisitBeneficiary> lstDetailVisitBeneficiary = new ArrayList<DetailVisitBeneficiary>();;
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idVisit);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				detailVisitBeneficiaryBean = new DetailVisitBeneficiary();
				detailVisitBeneficiaryBean.setIdVisit(rs.getInt(1));
				detailVisitBeneficiaryBean.setNote(rs.getString(3));
				detailVisitBeneficiaryBean.setUrlPhoto1(rs.getString(4));
				detailVisitBeneficiaryBean.setUrlPhoto2(rs.getString(5));
				beneficiaryBean = new BeneficiaryDAOImpl().findById(rs.getInt(2));
				detailVisitBeneficiaryBean.setBeneficiary(beneficiaryBean);
				lstDetailVisitBeneficiary.add(detailVisitBeneficiaryBean);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lstDetailVisitBeneficiary;
	}

	@Override
	public DetailVisitBeneficiary insert(DetailVisitBeneficiary detailVisitBeneficiary)
			throws BusinessException {
		
		String sql = "insert into detailvisitbeneficiary values(?,?,?,?,?) ";
		
		Connection conn = null;
		
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			detailVisitBeneficiary.setBeneficiary(new BeneficiaryDAOImpl().insert(detailVisitBeneficiary.getBeneficiary()));
			
			ps.setInt(1, detailVisitBeneficiary.getIdVisit());
			ps.setInt(2, detailVisitBeneficiary.getBeneficiary().getIdBeneficiary());
			ps.setString(3, detailVisitBeneficiary.getNote());
			ps.setString(4, detailVisitBeneficiary.getUrlPhoto1());
			ps.setString(5, detailVisitBeneficiary.getUrlPhoto2());
						
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return detailVisitBeneficiary;
	}

		
}
