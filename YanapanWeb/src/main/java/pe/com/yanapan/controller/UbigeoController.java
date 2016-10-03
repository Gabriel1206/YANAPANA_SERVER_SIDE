package pe.com.yanapan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Ubigeo;
import pe.com.yanapan.service.UbigeoService;


@Controller
public class UbigeoController {

	@Autowired
	private UbigeoService service;
	
	@RequestMapping(value = "v1/ubigeo/{idUbigeo}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = "application/json")
	public @ResponseBody Ubigeo buscarUbigeo(@PathVariable int idUbigeo) throws BusinessException{
		return service.findById(idUbigeo);		
	}
	
	
	@RequestMapping(value = "v1/ubigeo", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = "application/json")
	public @ResponseBody List<Ubigeo> listarUbigeos() throws BusinessException{
		return service.listAll();
	}
	
}
