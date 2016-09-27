package pe.com.yanapan.utils;

public class OperadoresUtil {
	
	public static Integer obtenerCociente(Integer dividendo, Integer divisor) {
		if ((dividendo % divisor) == 0) {
			return dividendo / divisor;
		} else {
			return dividendo / divisor + 1;
		}
	}

}
