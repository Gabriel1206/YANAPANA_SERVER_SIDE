package pe.com.yanapan.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import pe.com.yanapan.dao.WorkingDateDAO;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.WorkingDate;
import pe.com.yanapan.utils.ClsConexion;

public class WorkingDateDAOImpl implements WorkingDateDAO {

	private  ClsConexion conexion= new ClsConexion();
	
	@Override
	public List<WorkingDate> findById(int idWorkingDate) throws BusinessException {
		
		String sql = "select idWorkingDate, time, type, User_idUsser from workingdate "
				+ "where idWorkingDate = ?";
		
		Connection conn = null;
		WorkingDate workingDateBean = null;
		List<WorkingDate> lstWorkingDates = new ArrayList<WorkingDate>();
		
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idWorkingDate);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				workingDateBean = new WorkingDate();
				workingDateBean.setIdWorkingDate(rs.getInt(1));
				workingDateBean.setTime(rs.getDate(2));
				workingDateBean.setType(rs.getString(3));
				workingDateBean.setUser(new UserDAOImpl().findById(rs.getInt(4)));
				lstWorkingDates.add(workingDateBean);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstWorkingDates;
	}

	@Override
	public List<WorkingDate> findByUser(int idUser) throws BusinessException {
		String sql = "select idWorkingDate, time, type, User_idUsser from workingdate "
				+ "where User_idUser = ?";
		
		Connection conn = null;
		WorkingDate workingDateBean = null;
		List<WorkingDate> lstWorkingDates = new ArrayList<WorkingDate>();
		
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idUser);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				workingDateBean = new WorkingDate();
				workingDateBean.setIdWorkingDate(rs.getInt(1));
				workingDateBean.setTime(rs.getDate(2));
				workingDateBean.setType(rs.getString(3));
				workingDateBean.setUser(new UserDAOImpl().findById(rs.getInt(4)));
				lstWorkingDates.add(workingDateBean);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstWorkingDates;
	}

	@Override
	public WorkingDate insert(WorkingDate workingDate) throws BusinessException {
		
		String sql = "insert into workingdate(time,type,User_idUser) values(?,?,?) ";
		Connection conn = null;
						
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, (Date) workingDate.getTime());
			ps.setString(2, workingDate.getType());
			ps.setInt(3, workingDate.getUser().getIdUser());
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workingDate;
	}

	@Override
	public List<WorkingDate> listAll() throws BusinessException {
		
		String sql = "select idWorkingDate, time, type, User_idUser from workingdate ";
		
		Connection conn = null;
		WorkingDate workingDateBean = null;
		List<WorkingDate> lstWorkingDates = new ArrayList<WorkingDate>();
		
		try {
			conn = conexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				workingDateBean = new WorkingDate();
				workingDateBean.setIdWorkingDate(rs.getInt(1));
				workingDateBean.setTime(rs.getDate(2));
				workingDateBean.setType(rs.getString(3));
				workingDateBean.setUser(new UserDAOImpl().findById(rs.getInt(4)));
				lstWorkingDates.add(workingDateBean);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstWorkingDates;		
	}

	

}
