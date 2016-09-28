package pe.com.yanapan.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * 
 * @author Manuel Castañeda
 * Clase que lee y retorna las propiedades que se encuentran en
 * el archivo properties.
 *
 **/

public class ClsProperties {

	
	public Properties getProperties(){
		
		try
        {
			InputStream in = null;
            //se crea una instancia a la clase Properties
            //se leen el archivo .properties
            Properties propiedades;
            propiedades=new Properties();
            File file = null;
            //if ( (System.getProperty("os.name")).equals("Windows") ) 
            	//file= new File("D:/UPC/moviles/conexion.properties");
            /*else*/
            	file= new File("/usr/share/jboss-eap-6.1/conexion/conexion.properties");
            
            in=new FileInputStream(file);
            propiedades.load(in);
            
            //si el archivo de propiedades NO esta vacio retornan las propiedes leidas
            if (!propiedades.isEmpty()) 
            {                
                return propiedades;
            } else {//sino  retornara NULL
                return null;
            }
        } catch (IOException ex) {
            return null;
        }
		
		
		
	}
	
}
