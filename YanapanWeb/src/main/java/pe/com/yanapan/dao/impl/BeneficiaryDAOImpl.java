package pe.com.yanapan.dao.impl;

import java.sql.Connection;
<<<<<<< HEAD
import java.sql.Date;
=======
>>>>>>> d94ce494ab9f8c5610d34c6dd957abaa74de1c6c
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import pe.com.yanapan.dao.BeneficiaryDAO;
import pe.com.yanapan.dao.UbigeoDAO;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Beneficiary;
import pe.com.yanapan.model.TypeBeneficiary;
import pe.com.yanapan.model.Ubigeo;
import pe.com.yanapan.utils.ClsConexion;

public class BeneficiaryDAOImpl implements BeneficiaryDAO{

	private  ClsConexion conexion= new ClsConexion();
	
	@Override
	public Beneficiary findById(int idBeneficiary) throws BusinessException {
		
		String sql = "select idBeneficiary,documentBeneficiary, firstName, lastName,birthDate,address,"
				+ "flagDisabled,flagKnowledge,descKnowledge,Ubigeo_idUbigeo,TypeBeneficiary_idTypeBeneficiary "
				+ "from workingdate "
				+ "where idBeneficiary = ?";
		
		Connection conn = null;
		Beneficiary beneficiaryBean = null;
		Ubigeo ubigeoBean = null;
		TypeBeneficiary typeBeneficiaryBean = null;
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idBeneficiary);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				beneficiaryBean = new Beneficiary();
				beneficiaryBean.setIdBeneficiary(rs.getInt(1));
				beneficiaryBean.setDocumentBeneficiary(rs.getString(2));
				beneficiaryBean.setFirstName(rs.getString(3));
				beneficiaryBean.setLastName(rs.getString(4));
				beneficiaryBean.setBirthdate(rs.getDate(5));
				beneficiaryBean.setAddress(rs.getString(6));
				beneficiaryBean.setFlagDisabled(rs.getString(7));
				beneficiaryBean.setFlagKnowledge(rs.getString(8));
				beneficiaryBean.setDescKnowledge(rs.getString(9));
				ubigeoBean =  new UbigeoDAOImpl().findById(rs.getInt(10));
				beneficiaryBean.setUbigeo(ubigeoBean);
				typeBeneficiaryBean = new TypeBeneficiaryDAOImpl().findById(rs.getInt(11));
				beneficiaryBean.setTypeBeneficiary(typeBeneficiaryBean);
=======
import org.springframework.stereotype.Repository;

import pe.com.yanapan.dao.BeneficiaryDAO;
import pe.com.yanapan.model.Beneficiary;
import pe.com.yanapan.utils.ClsConexion;

@Repository
public class BeneficiaryDAOImpl implements BeneficiaryDAO {

	private  Connection conn=null;
	private  ClsConexion conexion= new ClsConexion();

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
>>>>>>> d94ce494ab9f8c5610d34c6dd957abaa74de1c6c
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
<<<<<<< HEAD
		return beneficiaryBean;
	}

	@Override
	public List<Beneficiary> listAll() throws BusinessException {

		String sql = "select idBeneficiary,documentBeneficiary, firstName, lastName,birthDate,address,"
				+ "flagDisabled,flagKnowledge,descKnowledge,Ubigeo_idUbigeo,TypeBeneficiary_idTypeBeneficiary "
				+ "from workingdate ";
		
		Connection conn = null;
		Beneficiary beneficiaryBean = null;
		Ubigeo ubigeoBean = null;
		TypeBeneficiary typeBeneficiaryBean = null;
		List<Beneficiary> lstBeneficiaryBean = new ArrayList<Beneficiary>();
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				beneficiaryBean = new Beneficiary();
				beneficiaryBean.setIdBeneficiary(rs.getInt(1));
				beneficiaryBean.setDocumentBeneficiary(rs.getString(2));
				beneficiaryBean.setFirstName(rs.getString(3));
				beneficiaryBean.setLastName(rs.getString(4));
				beneficiaryBean.setBirthdate(rs.getDate(5));
				beneficiaryBean.setAddress(rs.getString(6));
				beneficiaryBean.setFlagDisabled(rs.getString(7));
				beneficiaryBean.setFlagKnowledge(rs.getString(8));
				beneficiaryBean.setDescKnowledge(rs.getString(9));
				ubigeoBean =  new UbigeoDAOImpl().findById(rs.getInt(10));
				beneficiaryBean.setUbigeo(ubigeoBean);
				typeBeneficiaryBean = new TypeBeneficiaryDAOImpl().findById(rs.getInt(11));
				beneficiaryBean.setTypeBeneficiary(typeBeneficiaryBean);
				lstBeneficiaryBean.add(beneficiaryBean);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstBeneficiaryBean;
	}

	@Override
	public Beneficiary insert(Beneficiary beneficiary) throws BusinessException {
		
		String sql = "insert into (documentBeneficiary,firstName,lastName,birthDate,address,"
				+ "flagDisabled,flagKnowledge,descKnowledge,Ubigeo_idUbigeo,"
				+ "TypeBeneficiary_idTypeBeneficiary) beneficiary "
				+ "values(?,?,?,?,?,?,?,?,?,?) ";
		
		Connection conn = null;
		
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, beneficiary.getDocumentBeneficiary());
			ps.setString(2, beneficiary.getFirstName());
			ps.setString(3, beneficiary.getLastName());
			ps.setDate(4, (Date) beneficiary.getBirthdate());
			ps.setString(5, beneficiary.getAddress());
			ps.setString(6, beneficiary.getFlagDisabled());
			ps.setString(7, beneficiary.getFlagKnowledge());
			ps.setString(8, beneficiary.getDescKnowledge());
			ps.setInt(9, beneficiary.getUbigeo().getIdUbigeo());
			ps.setInt(10, beneficiary.getTypeBeneficiary().getIdTypeBeneficiary());
			
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beneficiary;
	}

	@Override
	public Beneficiary update(Beneficiary beneficiary) throws BusinessException {
		String sql = "update beneficiary set documentBeneficiary = ?,firstName = ?, lastName = ?, birthDate = ?, address = ?,"
				+ "flagDisabled = ?,flagKnowledge = ?,descKnowledge = ?,Ubigeo_idUbigeo = ?, TypeBeneficiary_idTypeBeneficiary = ? "
				+ "where idBeneficiary = ? ";
		Connection conn = null;
		
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, beneficiary.getDocumentBeneficiary());
			ps.setString(2, beneficiary.getFirstName());
			ps.setString(3, beneficiary.getLastName());
			ps.setDate(4, (Date) beneficiary.getBirthdate());
			ps.setString(5, beneficiary.getAddress());
			ps.setString(6, beneficiary.getFlagDisabled());
			ps.setString(7, beneficiary.getFlagKnowledge());
			ps.setString(8, beneficiary.getDescKnowledge());
			ps.setInt(9, beneficiary.getUbigeo().getIdUbigeo());
			ps.setInt(10, beneficiary.getTypeBeneficiary().getIdTypeBeneficiary());
			ps.setInt(11, beneficiary.getIdBeneficiary());
			
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beneficiary;
	}

	
	
=======
		return lstBeneficiary;
	}

>>>>>>> d94ce494ab9f8c5610d34c6dd957abaa74de1c6c
}
