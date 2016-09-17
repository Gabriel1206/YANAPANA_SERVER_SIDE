package pe.com.yanapan.beans;

import java.util.List;

public class GenericResponseBean<T> {
	
	private T objeto;
	
	public T getObjeto() {
		return objeto;
	}
	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}

	@Override
	public String toString() {
		return "GenericResponseBean [objeto=" + objeto + "]";
	}
	
	
}
