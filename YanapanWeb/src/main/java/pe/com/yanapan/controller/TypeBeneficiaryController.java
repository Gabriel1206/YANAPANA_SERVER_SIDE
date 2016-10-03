package pe.com.yanapan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.TypeBeneficiary;
import pe.com.yanapan.service.TypeBeneficiaryService;


@Controller
public class TypeBeneficiaryController {

	@Autowired
	private TypeBeneficiaryService service;
	
	@RequestMapping(value = "v1/typebeneficiary", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = "application/json")
	public @ResponseBody List<TypeBeneficiary> listarTiposBeneficiarios() throws BusinessException{
		return service.listAll();
	}
	
}
