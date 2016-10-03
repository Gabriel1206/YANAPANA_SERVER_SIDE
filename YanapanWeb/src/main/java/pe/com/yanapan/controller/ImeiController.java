package pe.com.yanapan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.Messages;

import pe.com.yanapan.beans.GenericResponseBean;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Imei;
import pe.com.yanapan.service.ImeiService;
import pe.com.yanapan.utils.GlobalMessages;

@Controller
public class ImeiController {

	@Autowired
	private ImeiService service;
	
	@RequestMapping(value = "v1/imei/{descImei}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = "application/json")
	public @ResponseBody Imei findImei(
			@PathVariable String descImei) throws BusinessException {
		Imei imeiBean = service.findByDescription(descImei);
		
		return imeiBean;		
	}
	
	@RequestMapping(value = "/v1/imei", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Imei registarImei(@RequestBody Imei imei) throws BusinessException{
		
		return service.insert(imei);		
	}
	
}
