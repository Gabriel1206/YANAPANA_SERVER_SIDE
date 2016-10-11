package pe.com.yanapan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Visit;
import pe.com.yanapan.service.VisitService;

@Controller
public class VisitController extends ExceptionHandlingController{

	@Autowired
	private VisitService service;
	
	@RequestMapping(value = "/v1/visit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Visit registrarVisita(
			@RequestBody Visit visit) throws BusinessException{	
		return service.insert(visit);
	}
	
	@RequestMapping(value = "v1/visit", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = "application/json")
	public @ResponseBody List<Visit> listarVisitas() throws BusinessException{
		return service.listAll();
	}
	
	@RequestMapping(value = "v1/visit/{idVisit}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = "application/json")
	public @ResponseBody Visit buscarVisita(@PathVariable int idVisit) throws BusinessException{
		return service.findById(idVisit);
	}
	
}
