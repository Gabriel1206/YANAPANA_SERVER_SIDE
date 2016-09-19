package pe.com.yanapan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.yanapan.beans.GenericResponseBean;
import pe.com.yanapan.exceptions.BusinessException;
import pe.com.yanapan.model.Imei;
import pe.com.yanapan.model.User;
import pe.com.yanapan.service.UserService;
import pe.com.yanapan.utils.GlobalMessages;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value = "users/validate", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
	public @ResponseBody GenericResponseBean<User> validateAcces(
			String user, String password) throws BusinessException {
		GenericResponseBean<User> responseBean = new GenericResponseBean<User>();
		responseBean.setObjeto(service.findByUserAndPassword(user, password));
		
		return responseBean;		
	} 
}
