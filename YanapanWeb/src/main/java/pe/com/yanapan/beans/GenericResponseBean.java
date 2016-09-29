package pe.com.yanapan.beans;

import java.util.List;

public class GenericResponseBean<T> {

	
	private T objeto;
	private String respuesta;
	private String mensaje;
	
	public T getObjeto() {
		return objeto;
	}
	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}

	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	

}
