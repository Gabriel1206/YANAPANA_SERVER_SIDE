package pe.com.yanapan.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 
 * @author Manuel Castañeda
 * Clase que permite obtener la conexión a la BD mediante los 
 * parametro que obtiene de la clase Propiedades
 *
 */

public class ClsConexion {

	private  Properties propiedades = new ClsProperties().getProperties();
	private  String ip=propiedades.getProperty("IP");
	private  String bd=propiedades.getProperty("BD");
	private  String port=propiedades.getProperty("PORT");
	private  String usuario=propiedades.getProperty("USER");
	private  String password=propiedades.getProperty("PASSWORD");
	 
	 
	public  Connection getConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
					
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://"+ip+":"+port+"/"+bd,usuario ,password);
			
			return conn;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
		
}
