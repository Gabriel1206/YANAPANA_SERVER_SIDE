package pe.com.yanapan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value = "v1/imei", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = "application/json")
	public @ResponseBody String findImei(
			String descImei) throws BusinessException {
		GenericResponseBean<Imei> responseBean = new GenericResponseBean<Imei>();
		responseBean.setObjeto(service.findByDescription(descImei));
		if(responseBean.getObjeto() != null){
			return GlobalMessages.OK;
		}
		return GlobalMessages.ERROR;		
	}
	
}
