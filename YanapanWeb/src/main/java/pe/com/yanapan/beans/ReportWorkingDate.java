package pe.com.yanapan.beans;

import java.util.List;

import pe.com.yanapan.model.WorkingDate;


public class ReportWorkingDate {

	List<WorkingDate> listUser;
	int totalregistros;
	public List<WorkingDate> getListUser() {
		return listUser;
	}
	public void setListUser(List<WorkingDate> listUser) {
		this.listUser = listUser;
	}
	public int getTotalregistros() {
		return totalregistros;
	}
	public void setTotalregistros(int totalregistros) {
		this.totalregistros = totalregistros;
	}
		
	
}
