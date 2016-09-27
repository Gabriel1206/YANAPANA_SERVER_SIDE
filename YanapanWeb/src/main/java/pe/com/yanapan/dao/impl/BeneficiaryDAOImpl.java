package pe.com.yanapan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.yanapan.dao.BeneficiaryDAO;
import pe.com.yanapan.model.Beneficiary;
import pe.com.yanapan.utils.ClsConexion;

@Repository
public class BeneficiaryDAOImpl implements BeneficiaryDAO {

	private  Connection conn=null;
	private  ClsConexion conexion= new ClsConexion();
	
	@SuppressWarnings("unchecked")
	@Autowired
	//private DatosSession datosSession;

	@Override
	public List<Beneficiary> listAllBeneficiary() {
		// TODO Auto-generated method stub
		String sql = "select b.idBeneficiary, b.firstName, b.lastName, b.birthDate, b.address, b.flagDisabled, "
				+ "b.flagKnowledge, b.descKnowledge "
				+ "from beneficiary b ";
		List<Beneficiary> lstBeneficiary = new ArrayList<>();
		Connection conn = null;
		Beneficiary beneficiaryBean = null;
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				beneficiaryBean = new Beneficiary();
				beneficiaryBean.setIdBeneficiary(rs.getInt(1));
				beneficiaryBean.setFirstName(rs.getString(2));
				beneficiaryBean.setLastName(rs.getString(3));
				beneficiaryBean.setBirthDate(rs.getDate(4));
				beneficiaryBean.setAddress(rs.getString(5));
				beneficiaryBean.setFlagDisabled((char) rs.getByte(6));
				beneficiaryBean.setFlagKnowledge((char) rs.getByte(7));
				beneficiaryBean.setDescKnowledge(rs.getString(8));
				//beneficiaryBean.setIdUbigeo(rs.getInt(9));
				//beneficiaryBean.setTypeBeneficiary(rs.getInt(10));
				lstBeneficiary.add(beneficiaryBean);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lstBeneficiary;
	}

}
