package pe.com.yanapan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.WorkingDate;
import pe.com.yanapan.service.WorkingDateService;

@Controller
public class WorkingDateController extends ExceptionHandlingController{

	@Autowired
	private WorkingDateService service;
	
	@RequestMapping(value = "/v1/workingdate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody WorkingDate insertarWorkingDate(
			@RequestBody WorkingDate workingDate) throws BusinessException{
		return service.insert(workingDate);		
	}
	
	@RequestMapping(value = "/v1/workingdate", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = "application/json")
	public @ResponseBody List<WorkingDate> listarWorkingDate() throws BusinessException{
		
		return service.listAll();
	}
	
}
