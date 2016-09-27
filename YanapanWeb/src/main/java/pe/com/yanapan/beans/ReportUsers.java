package pe.com.yanapan.beans;

import java.util.List;

import pe.com.yanapan.model.User;

public class ReportUsers {
	List<User> listUser;
	int totalregistros;
	
	public List<User> getListUser() {
		return listUser;
	}
	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}
	public int getTotalregistros() {
		return totalregistros;
	}
	public void setTotalregistros(int totalregistros) {
		this.totalregistros = totalregistros;
	}
	
}
