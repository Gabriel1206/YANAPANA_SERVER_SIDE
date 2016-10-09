package pe.com.yanapan.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pe.com.yanapan.exceptions.*;


@Controller
public class ExceptionHandlingController {
	  @ExceptionHandler(BusinessException.class)
	  public  @ResponseBody Map<String, Object> errorDeNegocio(HttpServletRequest req,HttpServletResponse response, Exception exception) {

		  exception.printStackTrace();
		  response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		  Map<String, Object> genericResponse=new HashMap<String, Object>();
		  genericResponse.put("mensaje", exception.getMessage());
		  return genericResponse;
	  }

	 
	  @ExceptionHandler(Exception.class)
	  public @ResponseBody Map<String, Object> errorGenerico(HttpServletRequest req,HttpServletResponse response, Exception exception) {
		  exception.printStackTrace();
		  response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		  Map<String, Object> genericResponse=new HashMap<String, Object>();
		  genericResponse.put("mensaje", "Lo sentimos, no se ha podido completar la operacion, por favor intentelo mas tarde.");

		
		return genericResponse;
	  }

}
